package bupt.zssdhl.SSHFrame.Action.File;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import bupt.zssdhl.SSHFrame.Bean.FileInfo;
import bupt.zssdhl.SSHFrame.Service.FileService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateFilePreAction extends ActionSupport{
	
	private FileInfo fileInfo;
	private FileService fileService;
	private Log _log = LogFactory.getLog(UpdateFilePreAction.class);
	
	@Override
	public String execute() throws Exception{
		fileInfo = fileService.getFileInfoById(fileInfo.getId());
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("fileInfo",fileInfo);
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
