package bupt.zssdhl.SSHFrame.Dao;

import java.util.List;

import bupt.zssdhl.SSHFrame.Bean.FileInfo;

public interface FileInfoDao {
	
	public void addFileInfo(FileInfo fileInfo);
	
	public void delFileInfo(FileInfo fileInfo);
	
	public void updateFileInfo(FileInfo fileInfo);
	
	//通过文件id获得文件信息
	public FileInfo findFileInfosById(Integer id);
	//通过MD5值获得文件信息  用于判断是否存在相同文件
	public FileInfo findeFileInfosByMD5(String MD5);
	//分页获取用户的文件
	public List<FileInfo> findFileInfosByUserId(Integer id,int firstResult,int maxResult);
	
	public int getFileCountByUserId(Integer id);
	//分页获取公共文件
	public List<FileInfo> findPublicFileInfos(int firstResult,int maxResult);
	
	public int getPublicFileCount();
	
	//分页获取全部文件
	public List<FileInfo> findAllFileInfos(int firstResult,int maxResult);
	
	public int getAllFileCount();
	
	
}
