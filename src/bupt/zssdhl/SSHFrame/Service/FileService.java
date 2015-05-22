package bupt.zssdhl.SSHFrame.Service;

import java.io.File;
import java.util.List;

import bupt.zssdhl.SSHFrame.Bean.FileInfo;
import bupt.zssdhl.SSHFrame.Bean.UserInfo;

public interface FileService {
	
	public int getOwnerPageSum(int id, int pageCount);
	
	public int getPublicPageSum(int pageCount);
	
	public int getAllPageSum(int pageCount);
	
	public List<FileInfo> listOwnerFileInfosLimit(int id, int pageGoto,int pageCount);
	
	public List<FileInfo> listPublicFileInfosLimit(int pageGoto,int pageCount);
	
	public List<FileInfo> listAllFileInfosLimit(int pageGoto,int pageCount);
	
	//fileInfo中 fileName grade userinfo 是必须的
	public void addFile(File file,String basePath, FileInfo fileInfo);
	
	public FileInfo getFileInfoById(int id);
	
	public void updateFileInfo(FileInfo fileInfo);
	
	public void delUserFile(FileInfo fileInfo);
}
