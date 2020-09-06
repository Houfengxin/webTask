package com.example.demo.model;

@lombok.Data
public class Data {
    private String id;
    private String dataname;
    private String define;
    private String content;
    public Data(String id, String dataname, String define,String content){
        this.setId(id);
        this.setDataname(dataname);
        this.setContent(content);
        this.setDefine(define);
    }
    public Data(){}
}
