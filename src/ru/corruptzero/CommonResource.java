package ru.corruptzero;

public class CommonResource {
    private static CommonResource INSTANCE = null;

    private String str = "";

    private CommonResource() {
    }

    public static CommonResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CommonResource();
        }
        return INSTANCE;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
