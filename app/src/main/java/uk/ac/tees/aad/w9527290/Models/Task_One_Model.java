package uk.ac.tees.aad.w9527290.Models;

public class Task_One_Model {

    String raps,excerciseName,targetArea;
    int imagepos;

    public Task_One_Model(String rap, String excerciseName, String targetArea, int imagepos) {
        this.raps = rap;
        this.excerciseName = excerciseName;
        this.targetArea = targetArea;
        this.imagepos = imagepos;
    }

    public String getRaps() {
        return raps;
    }

    public void setRaps(String raps) {
        this.raps = raps;
    }

    public String getExcerciseName() {
        return excerciseName;
    }

    public void setExcerciseName(String excerciseName) {
        this.excerciseName = excerciseName;
    }

    public String getTargetArea() {
        return targetArea;
    }

    public void setTargetArea(String targetArea) {
        this.targetArea = targetArea;
    }

    public int getImagepos() {
        return imagepos;
    }

    public void setImagepos(int imagepos) {
        this.imagepos = imagepos;
    }
}
