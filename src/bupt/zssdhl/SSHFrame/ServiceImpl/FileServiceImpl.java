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
	 * ��ø����ļ���ҳ����
	 */
	@Override
	public int getOwnerPageSum(int id, int pageCount) {
		return (fileInfoDao.getFileCountByUserId(id)-1)/pageCount + 1;
	}
	
	/**
	 * ��ù����ļ���ҳ����
	 */
	@Override
	public int getPublicPageSum(int pageCount) {
		return (fileInfoDao.getPublicFileCount()-1)/pageCount + 1;
	}
	
	/**
	 * ��ȡȫ���ļ���ҳ����
	 */
	@Override
	public int getAllPageSum(int pageCount) {
		return (fileInfoDao.getAllFileCount()-1)/pageCount + 1;
	}
	
	/**
	 * ��ҳ��ȡ�����ļ��б�
	 */
	@Override
	public List<FileInfo> listOwnerFileInfosLimit(int id, int pageGoto,
			int pageCount) {
		
		return fileInfoDao.findFileInfosByUserId(id, (pageGoto-1)*pageCount, pageCount);
	}
	
	/**
	 * ��ҳ��ȡ������Դ
	 */
	@Override
	public List<FileInfo> listPublicFileInfosLimit(int pageGoto, int pageCount) {
		
		return fileInfoDao.findPublicFileInfos((pageGoto-1)*pageCount, pageCount);
	}
	
	/**
	 * ��ҳ��ȡȫ����Դ
	 */
	@Override
	public List<FileInfo> listAllFileInfosLimit(int pageGoto, int pageCount) {
		
		return fileInfoDao.findAllFileInfos((pageGoto-1)*pageCount, pageCount);
	}
	
	/**
	 * ����ϵͳ���Ƿ����ظ��ļ�
	 */
	@Override
	public FileInfo getFileInfoByMD5(String MD5) {
		
		return fileInfoDao.findeFileInfosByMD5(MD5);
	}
	
	/**
	 * �����ݿ�����ļ���Ϣ���ҽ��ļ��ϴ���������
	 * fileinfo�� filename grade userinfo�Ѿ����ú�
	 */
	@Override
	public void addFile(File file,String basePath, FileInfo fileInfo) {
		FileInfo checkFileInfo = null;
		String MD5 = null;
		try {
			MD5 = MD5Util.getFileMD5String(file);
		} catch (IOException e1) {
			_log.error("�޷����MD5��");
		}
		
		fileInfo.setMD5(MD5);
		fileInfo.setDownloadTimes(0);
		fileInfo.setUploadDate(new Date(System.currentTimeMillis()));
		
		checkFileInfo = getFileInfoByMD5(MD5);
		if(null != checkFileInfo){
			//�����ظ��ļ�
			_log.info("�ļ��Ѿ������ڷ������������ظ��ϴ�");
			fileInfo.setFilePath(checkFileInfo.getFilePath());
			fileInfo.setUuName(checkFileInfo.getUuName());
		}else{
			_log.info("�����ϴ��ļ�������������������");
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
				_log.error("�ϴ��ļ���������ʧ�ܣ�");
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
	 * ͨ���ļ�id����ļ���Ϣ
	 */
	@Override
	public FileInfo getFileInfoById(int id) {
		return fileInfoDao.findFileInfosById(id);
	}
	
	/**
	 * �����ļ������ݿ���Ϣ
	 */
	@Override
	public void updateFileInfo(FileInfo fileInfo) {
		fileInfoDao.updateFileInfo(fileInfo);
		
	}
	
	/**
	 * ɾ���ļ� �����������ļ����ݼ����ݿ��¼
	 * ���������ﲻ��ֱ��ɾ���������ϵ��ļ�
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
