package net.musecom.util;

public class Pagination {
	private int listSize;		//�ѹ��� ���� ����� ����
	private int rangeSize; 		//�ѹ��� ������ ������ ����
	private int page;
	private int totalCnt;		//��ü �ø� ��
	private int pageCnt;		//������ �� (��ü�÷� / listSize)
	private int startPage;		
	private int endPage;
	private int startList;
	
	private boolean prev;
	private boolean next;
	
	public int getListSize() {
		return listSize;
	}


	public int getRangeSize() {
		return rangeSize;
	}


	public int getPage() {
		return page;
	}


	public int getTotalCnt() {
		return totalCnt;
	}


	public int getPageCnt() {
		return pageCnt;
	}


	public int getStartPage() {
		return startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public int getStartList() {
		return startList;
	}


	public boolean isPrev() {
		return prev;
	}


	public boolean isNext() {
		return next;
	}

	public void setPageInfo(int page, int listSize, int rangeSize, int totalCnt) {
		this.page = page;
		this.listSize = listSize;
		this.rangeSize = rangeSize;
		this.totalCnt = totalCnt;
		
		//��ü ������
		int pageCnt =(int) Math.ceil(totalCnt/ (double) listSize) ;
		
		//������ ������
		int endPage = (int) Math.ceil(page /(double) rangeSize) * rangeSize;
		
		int realend = (int) Math.ceil((totalCnt * 1.0)/ listSize);
		
		//����������
		int startPage = (endPage - rangeSize) +1;
		
		if(realend < endPage) endPage = realend;
		System.out.println(endPage);
		
		//���� ��ȣ
		int startList = (page-1)*listSize;
		
		//������ư
		boolean prev = startPage == 1 ? false : true;
		
		//������ư
		boolean next = endPage > pageCnt ? false : true;
		if(endPage > pageCnt) {
			endPage = pageCnt;
			next = false;
		}
		this.pageCnt = pageCnt;
		this.endPage = endPage;
		this.startPage = startPage;
		this.startList = startList;
		this.prev = prev;
		this.next = next;
	}
	
}
