package uk.ac.tees.aad.w9527290.Models;

public class SecondChellange {

    int first_img;

    String dayText;

    public SecondChellange(int first_img, String dayText) {
        this.first_img = first_img;
        this.dayText = dayText;
    }

    public int getFirst_img() {
        return first_img;
    }

    public void setFirst_img(int first_img) {
        this.first_img = first_img;
    }

    public String getDayText() {
        return dayText;
    }

    public void setDayText(String dayText) {
        this.dayText = dayText;
    }

}
