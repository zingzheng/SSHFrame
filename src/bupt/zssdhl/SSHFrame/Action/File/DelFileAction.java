package bupt.zssdhl.SSHFrame.Action.File;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.omg.PortableInterceptor.SUCCESSFUL;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bupt.zssdhl.SSHFrame.Bean.FileInfo;
import bupt.zssdhl.SSHFrame.Bean.UserInfo;
import bupt.zssdhl.SSHFrame.Service.FileService;

public class DelFileAction extends ActionSupport{
	private FileService fileService;
	private FileInfo fileInfo;
	private int flag;
	private static Log _log = LogFactory.getLog(DelFileAction.class);
	
	@Override
	public String execute() throws Exception{
		Map map = ActionContext.getContext().getSession();
		UserInfo userInfo = (UserInfo) map.get("userSession");
		fileInfo = fileService.getFileInfoById(fileInfo.getId());
		if(fileInfo != null){
			if(userInfo.getGrade() == 0){
				//����Ա����
				fileService.delFile(fileInfo);
				if(flag == 1){
					return "success2";
				}else{
					return SUCCESS;
				}
			}else{
				if(userInfo.getId() != fileInfo.getUserInfo().getId()){
					//�Ƿ�����
					this.addActionError("��û��Ȩ�޽��иò�����");
					return "reject";
				}else{
					//�û��Լ�����
					fileService.delFile(fileInfo);
					return SUCCESS;
				}
			}
		}else{
			this.addActionError("����Դ�Ѿ������ڣ�");
			return "reject";
		}
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

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
