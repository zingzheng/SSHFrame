package bupt.zssdhl.SSHFrame.Bean;

public class Page {
	
	//��ǰҳ��
	private int PageCurrent;
	//��תҳ��
	private int pageGoto;
	//ÿҳ��Ŀ����
	private int pageCount;
	//��ҳ��
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
