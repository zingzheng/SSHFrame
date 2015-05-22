package bupt.zssdhl.SSHFrame.Action.File;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import bupt.zssdhl.SSHFrame.Bean.FileInfo;
import bupt.zssdhl.SSHFrame.Bean.Page;
import bupt.zssdhl.SSHFrame.Bean.UserInfo;
import bupt.zssdhl.SSHFrame.Service.FileService;

/**
 * 获取用户的文件列表
 * 为了方便分页，这里放弃了使用了hibernate的one to many
 * @author zss
 *
 */
public class ListFileAction extends ActionSupport{
	
	private FileService fileService;
	private static Log _log = LogFactory.getLog(ListFileAction.class);
	private Page page;
			
	@Override
	public String execute() throws Exception{
		
		Map map = ActionContext.getContext().getSession();
		UserInfo userInfo = (UserInfo) map.get("userSession");
		
		//非通过页码选择发送请求
		if(null == page){
			page = new Page();
			page.setPageGoto(1);
		}
		//设置每页显示5个文件
		page.setPageCount(5);
		page.setPageCurrent(page.getPageGoto());
		page.setPageSum(fileService.getOwnerPageSum(userInfo.getId(), page.getPageCount()));
		List<FileInfo> fileInfos = fileService.listOwnerFileInfosLimit(userInfo.getId(),
				page.getPageGoto(), page.getPageCount());
		
		Map requestMap = (Map)ActionContext.getContext().get("request");
		requestMap.put("files", fileInfos);
		requestMap.put("page", page);
		
		return SUCCESS;
	}
	
	public FileService getFileService() {
		return fileService;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
