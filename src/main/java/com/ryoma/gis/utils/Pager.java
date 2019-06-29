package com.ryoma.gis.utils;

/**
 * @ClassName Page
 * @Description TODO
 * @Author zhanghui
 * @Date 2019/2/21 17:07
 **/
import java.util.List;

public class Pager<T> {

    private Integer pageSize=10;

    private Integer totalRecord;

    private Integer totalPage;

    private Integer currentPage=1;

    private List<T> list;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }


    public Pager(Integer pageNo,Integer pageSize,List<T> sourceList){
        if(sourceList==null){
            this.totalRecord = sourceList.size();
            return ;
        }
        if(sourceList.size()==0){
            this.totalRecord = sourceList.size();
            return ;
        }

        //总记录数
        this.totalRecord = sourceList.size();

        //每页显示多小条数据
        this.pageSize = pageSize;

        //总页数
        this.totalPage = this.totalRecord % this.pageSize == 0?this.totalRecord/this.pageSize:this.totalRecord/this.pageSize+1;

        //当前第几页
        if(this.totalPage < pageNo){
            this.currentPage = this.totalPage;
        }else{
            this.currentPage = pageNo;
        }


        //起始索引
        Integer fromIndex = this.pageSize * (this.currentPage - 1);

        //结束索引
        Integer endIndex = null;
        if(this.pageSize * this.currentPage >this.totalRecord){
            endIndex = this.totalRecord;
        }else{
            endIndex = this.pageSize * this.currentPage;
        }

        this.list = sourceList.subList(fromIndex, endIndex);
    }

}
