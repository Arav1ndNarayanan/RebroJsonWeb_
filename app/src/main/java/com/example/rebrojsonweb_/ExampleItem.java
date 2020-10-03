package com.example.rebrojsonweb_;

public class ExampleItem {
    private String mImageUrl;
    private String mCreator;
    private int mLikes;
    String wid;
    String wfirstName;
    String wgender;
    String wmail;
    String wphoneH;
    String wphoneO;
    String wmobile;
    public ExampleItem(String id,  String firstName, String gender, String mail, String phoneH, String phoneO, String mobile) {
        wid=id;
        wfirstName =firstName;
        wgender =gender;
        wmail =mail;
        wphoneH =phoneH;
        wphoneO =phoneO;
        wmobile =mobile;
    }
    public String getId() {
        return wid;
    }
    public String getfirstName() {
        return wfirstName;
    }
    public String getGender() {
        return wgender;
    }
    public String getmail() {
        return wmail;
    }
    public String getphoneO() {
        return wphoneO;
    }
    public String getphoneH() {
        return wphoneH;
    }
    public String getMobile() {
        return wmobile;
    }
}