package bupt.zssdhl.SSHFrame.Bean;

import java.util.Set;

/**
 * 用户信息bean类
 * @author zss
 *
 */
public class UserInfo implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private String pwd;
	private String realname;
	private Integer grade;
	private String invitaCode;
	
	private Set<FileInfo> fileInfos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getInvitaCode() {
		return invitaCode;
	}
	public void setInvitaCode(String invitaCode) {
		this.invitaCode = invitaCode;
	}
	
	
	public Set<FileInfo> getFileInfos() {
		return fileInfos;
	}
	public void setFileInfos(Set<FileInfo> fileInfos) {
		this.fileInfos = fileInfos;
	}
	
	
	
}
