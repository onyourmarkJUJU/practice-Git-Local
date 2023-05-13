package com.bit.vo;

public class PageBean {
    private int currentBlock;
    private int currentPage;
    private int totalPage;
    private int startPage;
    private int endPage;

    public PageBean() {
        super();
    }

    //getter, setter, 생성자 단축키 : ctrl + insert
    public PageBean(int currentBlock, int currentPage, int totalPage, int startPage, int endPage) {
        this.currentBlock = currentBlock;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.startPage = startPage;
        this.endPage = endPage;
    }

    public int getCurrentBlock() {
        return currentBlock;
    }

    public void setCurrentBlock(int currentBlock) {
        this.currentBlock = currentBlock;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
}
