package bupt.zssdhl.SSHFrame.Bean;

import java.sql.Date;
import java.util.Set;

/**
 * 物理文件信息
 * @author zss
 *
 */
public class FilePhy implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String uuName;
	private String filePath;
	private String MD5;
	private Set<FileInfo> fileInfos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUuName() {
		return uuName;
	}
	public void setUuName(String uuName) {
		this.uuName = uuName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getMD5() {
		return MD5;
	}
	public void setMD5(String mD5) {
		MD5 = mD5;
	}
	public Set<FileInfo> getFileInfos() {
		return fileInfos;
	}
	public void setFileInfos(Set<FileInfo> fileInfos) {
		this.fileInfos = fileInfos;
	}
	
	
}
