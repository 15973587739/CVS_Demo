package cn.cvs.utils;

import java.io.Serializable;

/**
 * @Description 分页查询入参封装
 **/
public class Pager implements Serializable {
    //当前页
    private int pageNo;
    //总条数
    private int rowCount;
    //每页显示条数
    private int pageSize;
    //总页数
    private int pageCount;
    private String url;

    public Pager() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }


    public Pager(int rowCount, int rowPerPage, int currentPage) {

        this.rowCount = rowCount;
        this.pageSize = rowPerPage;
        this.pageNo = currentPage;
        if (this.rowCount % this.pageSize == 0) {
            this.pageCount = this.rowCount / this.pageSize;
        } else if (this.rowCount % this.pageSize > 0) {
            this.pageCount = this.rowCount / this.pageSize + 1;
        } else {
            this.pageCount = 0;
        }
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getPageCount() {
        return pageCount;
    }
}
