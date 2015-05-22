package bupt.zssdhl.SSHFrame.Action.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import bupt.zssdhl.SSHFrame.Bean.FileInfo;
import bupt.zssdhl.SSHFrame.Bean.UserInfo;
import bupt.zssdhl.SSHFrame.Service.FileService;
import bupt.zssdhl.SSHFrame.Util.MD5Util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadFileAction extends ActionSupport{
			
	private FileService fileService;
	private static Log _log = LogFactory.getLog(UploadFileAction.class);
	
	private List<Integer> grade;

	private List<File> file;
	private List<String> fileFileName;
	private List<String> fileContentType;
	
	@Override
	public String execute() throws Exception{
		
		Map map = ActionContext.getContext().getSession();
		UserInfo userInfo = (UserInfo) map.get("userSession");
		String root = ServletActionContext.getRequest().getRealPath("/upload");
		
		for(int i=0;i<file.size();i++){
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFileName(fileFileName.get(i));
			fileInfo.setGrade(grade.get(i));
			fileInfo.setUserInfo(userInfo);
			fileService.addFile(file.get(i),root, fileInfo);
	
		}
		
		
		return SUCCESS;
	}
	
	public FileService getFileService() {
		return fileService;
	}
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}
			
	public List<Integer> getGrade() {
		return grade;
	}

	public void setGrade(List<Integer> grade) {
		this.grade = grade;
	}

}
