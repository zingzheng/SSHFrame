package bupt.zssdhl.SSHFrame.Dao;

import bupt.zssdhl.SSHFrame.Bean.FilePhy;

public interface FilePhyDao {
	
	public void addFilePhy(FilePhy filePhy);
	
	public FilePhy getFilePhyByMD5(String MD5);
	
	
}
