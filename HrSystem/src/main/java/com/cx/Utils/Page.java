package com.cx.Utils;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {

    private int pageNow;
    private int total;
    private int pageSize;
    private List<T> content;

    public Page(int pageNow, int total, int pageSize, List<T> content){
        this.pageNow = pageNow;
        this.total = total;
        this.pageSize = pageSize;
        this.content = content;
    }

}