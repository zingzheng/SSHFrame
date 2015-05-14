package bupt.zssdhl.SSHFrame.Bean;

public class Page {
	
	//当前页码
	private int PageCurrent;
	//跳转页码
	private int pageGoto;
	//每页条目数量
	private int pageCount;
	//总页数
	private int pageSum;
	
	public int getPageCurrent() {
		return PageCurrent;
	}
	public void setPageCurrent(int pageCurrent) {
		PageCurrent = pageCurrent;
	}
	public int getPageGoto() {
		return pageGoto;
	}
	public void setPageGoto(int pageGoto) {
		this.pageGoto = pageGoto;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageSum() {
		return pageSum;
	}
	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}
	
	

}
