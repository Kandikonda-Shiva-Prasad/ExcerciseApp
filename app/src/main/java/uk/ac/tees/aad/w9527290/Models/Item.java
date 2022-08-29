package uk.ac.tees.aad.w9527290.Models;


public class Item {

   String  itemImg;
    String  itemName;
    String itemKcal;
    String itemKcal2;

    public Item(String itemImg, String itemName, String itemKcal, String itemKcal2) {

        this.itemImg = itemImg;
        this.itemName = itemName;
        this.itemKcal = itemKcal;
        this.itemKcal2 = itemKcal2;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemKcal() {
        return itemKcal;
    }

    public void setItemKcal(String itemKcal) {
        this.itemKcal = itemKcal;
    }

    public String getItemKcal2() {
        return itemKcal2;
    }

    public void setItemKcal2(String itemKcal2) {
        this.itemKcal2 = itemKcal2;
    }
}
