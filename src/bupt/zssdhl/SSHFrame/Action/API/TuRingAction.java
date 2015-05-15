package bupt.zssdhl.SSHFrame.Action.API;

import java.util.Map;

import bupt.zssdhl.SSHFrame.Bean.User;
import bupt.zssdhl.SSHFrame.Service.TuRingService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TuRingAction extends ActionSupport{
	
	private String msgReceive;
	private String msgSend;
	private TuRingService tuRingService;
	
	@Override
	public String execute() throws Exception{
		
		
		
		Map map = ActionContext.getContext().getSession();
		User  user = (User) map.get("userSession");
		String username = user.getUsername();
		
		String resp = tuRingService.talking(msgReceive,username);
		StringBuilder sb = new StringBuilder();
		sb.append(msgSend);
		
		sb.append(username);
		sb.append(": ");
		sb.append(msgReceive);
		sb.append("\n");
		sb.append("…Í…Í£∫ ");
		sb.append(resp);
		sb.append("\n");

		msgSend = sb.toString();
		msgReceive=null;
		return SUCCESS;
	}

	public String getMsgReceive() {
		return msgReceive;
	}

	public void setMsgReceive(String msgReceive) {
		this.msgReceive = msgReceive;
	}

	public String getMsgSend() {
		return msgSend;
	}

	public void setMsgSend(String msgSend) {
		this.msgSend = msgSend;
	}

	public TuRingService getTuRingService() {
		return tuRingService;
	}

	public void setTuRingService(TuRingService tuRingService) {
		this.tuRingService = tuRingService;
	}




}
