package com.example.lenovo.expendablelistviewwithrecyleview.models;

import java.util.List;

/**
 * Created by lenovo on 14/02/2018.
 */

public class MenuModel {
    public String header;
    public List<String> childs;

    public MenuModel(String header, List<String> childs) {
        this.header = header;
        this.childs = childs;
    }

    public String getHeader() {
        return header;
    }

    public List<String> getChilds() {
        return childs;
    }
}
