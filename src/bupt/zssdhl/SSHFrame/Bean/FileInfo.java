package bupt.zssdhl.SSHFrame.Bean;

import java.sql.Date;

public class FileInfo implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String uuName;
	private String fileName;
	private String filePath;
	private String MD5;
	private Integer grade;
	private Date uploadDate;
	private Integer downloadTimes;
	private UserInfo userInfo;
	
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public Integer getDownloadTimes() {
		return downloadTimes;
	}
	public void setDownloadTimes(Integer downloadTimes) {
		this.downloadTimes = downloadTimes;
	}
	
	
	
}
