package bupt.zssdhl.SSHFrame.Bean;

import java.sql.Date;

/**
 * 用户文件信息
 * @author zss
 *
 */
public class FileInfo implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String fileName;
	private Integer grade;
	private Date uploadDate;
	private Integer downloadTimes;
	private UserInfo userInfo;
	private FilePhy filePhy;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	public FilePhy getFilePhy() {
		return filePhy;
	}
	public void setFilePhy(FilePhy filePhy) {
		this.filePhy = filePhy;
	}
	
	
	
}
