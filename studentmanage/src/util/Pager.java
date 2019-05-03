package util;

public class Pager {

	private int totalPage = 0;	// 鎬婚〉鏁� 
	private int totalRecord = 0; // 鎬昏褰曟暟
	private int curPage = 1; 	// 褰撳墠椤电爜锛屼粠1寮�濮�
	private int PageSize = 5; // 姣忛〉鏄剧ず璁板綍鏁�
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		this.totalPage = (int) Math.ceil(this.totalRecord * 1.0 / PageSize);
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPageSize() {
		return PageSize;
	}
	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}
	@Override
	public String toString() {
		return "Pager [totalPage=" + totalPage + ", totalRecord=" + totalRecord + ", curPage=" + curPage + ", PageSize="
				+ PageSize + "]";
	}
	
	
}
