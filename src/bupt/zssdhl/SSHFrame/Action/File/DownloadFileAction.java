package bupt.zssdhl.SSHFrame.Action.File;

import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import bupt.zssdhl.SSHFrame.Bean.FileInfo;
import bupt.zssdhl.SSHFrame.Service.FileService;

public class DownloadFileAction extends ActionSupport{
	private FileService fileService;
	private FileInfo fileInfo;
	private static Log _log = LogFactory.getLog(DownloadFileAction.class);
	
	public InputStream getDownload(){

		return ServletActionContext.getServletContext().getResourceAsStream("\\upload\\"+fileInfo.getFilePhy().getUuName());
	}
	
	public String execute() throws Exception{
		
		fileInfo = fileService.getFileInfoById(fileInfo.getId());
		if(fileInfo == null || fileInfo.getFilePhy() == null){
			this.addActionError("该资源已经不存在！");
			return "reject";
		}
		fileInfo.setDownloadTimes(fileInfo.getDownloadTimes()+1);
		fileService.updateFileInfo(fileInfo);
		return SUCCESS;
	}
	
	public FileService getFileService() {
		return fileService;
	}
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	public FileInfo getFileInfo() {
		return fileInfo;
	}

	public void setFileInfo(FileInfo fileInfo) {
		this.fileInfo = fileInfo;
	}
	
	
}
