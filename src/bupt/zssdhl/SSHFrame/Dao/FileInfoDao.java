package bupt.zssdhl.SSHFrame.Dao;

import java.util.List;

import bupt.zssdhl.SSHFrame.Bean.FileInfo;

public interface FileInfoDao {
	
	public void addFileInfo(FileInfo fileInfo);
	
	public void delFileInfo(FileInfo fileInfo);
	
	public void updateFileInfo(FileInfo fileInfo);
	
	//ͨ���ļ�id����ļ���Ϣ
	public FileInfo findFileInfosById(Integer id);
	//ͨ��MD5ֵ����ļ���Ϣ  �����ж��Ƿ������ͬ�ļ�
	public FileInfo findeFileInfosByMD5(String MD5);
	//��ҳ��ȡ�û����ļ�
	public List<FileInfo> findFileInfosByUserId(Integer id,int firstResult,int maxResult);
	
	public int getFileCountByUserId(Integer id);
	//��ҳ��ȡ�����ļ�
	public List<FileInfo> findPublicFileInfos(int firstResult,int maxResult);
	
	public int getPublicFileCount();
	
	//��ҳ��ȡȫ���ļ�
	public List<FileInfo> findAllFileInfos(int firstResult,int maxResult);
	
	public int getAllFileCount();
	
	
}
