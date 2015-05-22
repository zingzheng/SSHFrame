package bupt.zssdhl.SSHFrame.Action.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import bupt.zssdhl.SSHFrame.Bean.FileInfo;
import bupt.zssdhl.SSHFrame.Service.FileService;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateFileAction extends ActionSupport{
	
	private FileInfo fileInfo;
	private FileService fileService;
	private Log _log = LogFactory.getLog(UpdateFileAction.class);
	
	@Override
	public void validate(){
		if(null == fileInfo.getFileName() || 
				"".equals(fileInfo.getFileName().trim())){
			this.addFieldError("fileInfo.fileName",
					this.getText("required",new String[]{"文件名"}));
		}
	}
	
	
	@Override
	public String execute() throws Exception{
		FileInfo fullInfo = fileService.getFileInfoById(fileInfo.getId());
		if(null == fullInfo){
			this.addActionError("该资源已经不存在！");
			return "reject";
		}
		fullInfo.setFileName(fileInfo.getFileName());
		fullInfo.setGrade(fileInfo.getGrade());
		fileService.updateFileInfo(fullInfo);
		addActionMessage("修改成功！");
		return SUCCESS;
	}
	
	public FileInfo getFileInfo() {
		return fileInfo;
	}
	public void setFileInfo(FileInfo fileInfo) {
		this.fileInfo = fileInfo;
	}
	public FileService getFileService() {
		return fileService;
	}
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

}
