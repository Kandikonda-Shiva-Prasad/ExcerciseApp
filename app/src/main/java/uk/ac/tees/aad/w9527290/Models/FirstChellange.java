package uk.ac.tees.aad.w9527290.Models;

public class FirstChellange {

    int first_img;

    String buttonControler;

    public FirstChellange(int firstimg, String btn) {
        this.first_img = firstimg;

        this.buttonControler = btn;

    }

    public FirstChellange() {

    }

    public int getFirst_img() {
        return this.first_img;
    }

    public void setFirst_img(int first_img) {
        this.first_img = first_img;
    }



    public String getButtonControler() {
        return this.buttonControler;
    }

    public void setButtonControler(String buttonControler) {
        this.buttonControler = buttonControler;
    }
}
