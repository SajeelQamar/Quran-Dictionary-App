package com.example.quranapp;

public class lecturemodel {
    String leftrow_eng,leftrow_arabic,leftrow_urdu,rightrow_eng,rightrow_arabic,rightrow_urdu;

    public String getLeftrow_urdu() {
        return leftrow_urdu;
    }

    public void setLeftrow_urdu(String leftrow_urdu) {
        this.leftrow_urdu = leftrow_urdu;
    }

    public String getRightrow_urdu() {
        return rightrow_urdu;
    }

    public void setRightrow_urdu(String rightrow_urdu) {
        this.rightrow_urdu = rightrow_urdu;
    }

    public lecturemodel(String leftrow_eng, String leftrow_arabic, String leftrow_urdu, String rightrow_eng, String rightrow_arabic, String rightrow_urdu) {
        this.leftrow_eng = leftrow_eng;
        this.leftrow_arabic = leftrow_arabic;
        this.leftrow_urdu=leftrow_urdu;
        this.rightrow_eng = rightrow_eng;
        this.rightrow_arabic = rightrow_arabic;
        this.rightrow_urdu=rightrow_urdu;
    }

    public String getLeftrow_eng() {
        return leftrow_eng;
    }

    public void setLeftrow_eng(String leftrow_eng) {
        this.leftrow_eng = leftrow_eng;
    }

    public String getLeftrow_arabic() {
        return leftrow_arabic;
    }

    public void setLeftrow_arabic(String leftrow_arabic) {
        this.leftrow_arabic = leftrow_arabic;
    }

    public String getRightrow_eng() {
        return rightrow_eng;
    }

    public void setRightrow_eng(String rightrow_eng) {
        this.rightrow_eng = rightrow_eng;
    }

    public String getRightrow_arabic() {
        return rightrow_arabic;
    }

    public void setRightrow_arabic(String rightrow_arabic) {
        this.rightrow_arabic = rightrow_arabic;
    }
}
