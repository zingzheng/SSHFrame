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
import bupt.zssdhl.SSHFrame.Bean.FilePhy;
import bupt.zssdhl.SSHFrame.Dao.FileInfoDao;
import bupt.zssdhl.SSHFrame.Dao.FilePhyDao;
import bupt.zssdhl.SSHFrame.Service.FileService;
import bupt.zssdhl.SSHFrame.Util.MD5Util;

public class FileServiceImpl implements FileService {
	
	private FileInfoDao fileInfoDao;
	private FilePhyDao filePhyDao;
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
	 * 往数据库添加用户/物理文件信息，且将文件上传到服务器
	 * fileinfo中 filename grade userinfo 需要在调用前设置好
	 */
	@Override
	public void addFile(File file,String basePath, FileInfo fileInfo) {
		
		String MD5 = null;
		try {
			MD5 = MD5Util.getFileMD5String(file);
		} catch (IOException e1) {
			_log.error("无法获得MD5！");
		}
		FilePhy filePhy = filePhyDao.getFilePhyByMD5(MD5);
		if(null == filePhy){
			//全新文件
			_log.info("正在上传文件到服务器。。。。。");
			
			//保存文件物理信息
			filePhy = new FilePhy();
			filePhy.setMD5(MD5);
			String fileName = fileInfo.getFileName();
			String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			String uuName = UUID.randomUUID().toString();
			filePhy.setUuName(uuName);
			String filePath = basePath + "\\" + uuName;
			filePhy.setFilePath(filePath);
			filePhyDao.addFilePhy(filePhy);
			
			//上传文件到服务器
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(file);
				File destFile = new File(basePath,uuName);
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
			
		}else{
			//服务器已经存在该文件
			_log.info("文件已经存在于服务器，无需重复上传");
		}
		
		//保存用户文件信息
		fileInfo.setDownloadTimes(0);
		fileInfo.setUploadDate(new Date(System.currentTimeMillis()));
		fileInfo.setFilePhy(filePhy);	
		fileInfoDao.addFileInfo(fileInfo);
	}
	
	/**
	 * 通过文件id获得用户文件信息
	 */
	@Override
	public FileInfo getFileInfoById(int id) {
		return fileInfoDao.findFileInfosById(id);
	}
	
	/**
	 * 更新用户文件的数据库信息
	 */
	@Override
	public void updateFileInfo(FileInfo fileInfo) {
		fileInfoDao.updateFileInfo(fileInfo);
		
	}
	
	/**
	 * 删除用户文件信息
	 */
	@Override
	public void delUserFile(FileInfo fileInfo) {
		fileInfoDao.delFileInfo(fileInfo);
	}
	
	public FilePhyDao getFilePhyDao() {
		return filePhyDao;
	}
	public void setFilePhyDao(FilePhyDao filePhyDao) {
		this.filePhyDao = filePhyDao;
	}



	

	
	

}
