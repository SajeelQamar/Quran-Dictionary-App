package com.example.quranapp;

public class lecture_no_model {
    String lec_no;

    public String getDummytable() {
        return dummytable;
    }

    public void setDummytable(String dummytable) {
        this.dummytable = dummytable;
    }

    String dummytable;

    public lecture_no_model(String lec_no,String dummytable) {
        this.lec_no = lec_no;
        this.dummytable = dummytable;
    }

    public String getLec_no() {
        return lec_no;
    }

    public void setLec_no(String lec_no) {
        this.lec_no = lec_no;
    }
}
