package bupt.zssdhl.SSHFrame.ServiceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import bupt.zssdhl.SSHFrame.Bean.FileInfo;
import bupt.zssdhl.SSHFrame.Dao.FileInfoDao;
import bupt.zssdhl.SSHFrame.Service.FileService;
import bupt.zssdhl.SSHFrame.Util.MD5Util;

public class FileServiceImpl implements FileService {
	
	private FileInfoDao fileInfoDao;
	private static Log _log = LogFactory.getLog(FileServiceImpl.class);
	
	public FileInfoDao getFileInfoDao() {
		return fileInfoDao;
	}
	public void setFileInfoDao(FileInfoDao fileInfoDao) {
		this.fileInfoDao = fileInfoDao;
	}
	
	/**
	 * 获得个人文件分页数量
	 */
	@Override
	public int getOwnerPageSum(int id, int pageCount) {
		return (fileInfoDao.getFileCountByUserId(id)-1)/pageCount + 1;
	}
	
	/**
	 * 获得共享文件分页数量
	 */
	@Override
	public int getPublicPageSum(int pageCount) {
		return (fileInfoDao.getPublicFileCount()-1)/pageCount + 1;
	}
	
	/**
	 * 获取全部文件分页数量
	 */
	@Override
	public int getAllPageSum(int pageCount) {
		return (fileInfoDao.getAllFileCount()-1)/pageCount + 1;
	}
	
	/**
	 * 分页获取个人文件列表
	 */
	@Override
	public List<FileInfo> listOwnerFileInfosLimit(int id, int pageGoto,
			int pageCount) {
		
		return fileInfoDao.findFileInfosByUserId(id, (pageGoto-1)*pageCount, pageCount);
	}
	
	/**
	 * 分页获取公有资源
	 */
	@Override
	public List<FileInfo> listPublicFileInfosLimit(int pageGoto, int pageCount) {
		
		return fileInfoDao.findPublicFileInfos((pageGoto-1)*pageCount, pageCount);
	}
	
	/**
	 * 分页获取全部资源
	 */
	@Override
	public List<FileInfo> listAllFileInfosLimit(int pageGoto, int pageCount) {
		
		return fileInfoDao.findAllFileInfos((pageGoto-1)*pageCount, pageCount);
	}
	
	/**
	 * 查找系统中是否有重复文件
	 */
	@Override
	public FileInfo getFileInfoByMD5(String MD5) {
		
		return fileInfoDao.findeFileInfosByMD5(MD5);
	}
	
	/**
	 * 往数据库添加文件信息，且将文件上传到服务器
	 * fileinfo中 filename grade userinfo已经设置好
	 */
	@Override
	public void addFile(File file,String basePath, FileInfo fileInfo) {
		FileInfo checkFileInfo = null;
		String MD5 = null;
		try {
			MD5 = MD5Util.getFileMD5String(file);
		} catch (IOException e1) {
			_log.error("无法获得MD5！");
		}
		
		fileInfo.setMD5(MD5);
		fileInfo.setDownloadTimes(0);
		fileInfo.setUploadDate(new Date(System.currentTimeMillis()));
		
		checkFileInfo = getFileInfoByMD5(MD5);
		if(null != checkFileInfo){
			//存在重复文件
			_log.info("文件已经存在于服务器，无需重复上传");
			fileInfo.setFilePath(checkFileInfo.getFilePath());
			fileInfo.setUuName(checkFileInfo.getUuName());
		}else{
			_log.info("正在上传文件到服务器。。。。。");
			String fileName = fileInfo.getFileName();
			String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			String uuName = UUID.randomUUID().toString();
			fileInfo.setUuName(uuName+fileType);
			String filePath = basePath + "\\" + fileInfo.getUuName();
			fileInfo.setFilePath(filePath);
			
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(file);
				File destFile = new File(basePath,fileInfo.getUuName());
				os = new FileOutputStream(destFile);
				byte[] buffer = new byte[1024];
				int length = 0;
				
				while((length = is.read(buffer))>0){
					os.write(buffer,0,length);
				}
			} catch (Exception e) {
				e.printStackTrace();
				_log.error("上传文件到服务器失败！");
			}finally{
				try {
					if(null != is)
						is.close();
					if(null != os)
						os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		fileInfoDao.addFileInfo(fileInfo);
		
		
	}
	
	/**
	 * 通过文件id获得文件信息
	 */
	@Override
	public FileInfo getFileInfoById(int id) {
		return fileInfoDao.findFileInfosById(id);
	}
	
	/**
	 * 更新文件的数据库信息
	 */
	@Override
	public void updateFileInfo(FileInfo fileInfo) {
		fileInfoDao.updateFileInfo(fileInfo);
		
	}
	
	/**
	 * 删除文件 包括服务器文件内容及数据库记录
	 * 更正，这里不能直接删除服务器上的文件
	 */
	@Override
	public void delFile(FileInfo fileInfo) {
		fileInfoDao.delFileInfo(fileInfo);
		File file = new File(fileInfo.getFilePath());
		if(file.exists()){
			file.delete();
		}
		
	}



	

	
	

}
