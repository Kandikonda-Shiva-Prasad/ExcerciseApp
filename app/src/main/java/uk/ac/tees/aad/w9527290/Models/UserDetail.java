package uk.ac.tees.aad.w9527290.Models;

public class UserDetail {

    private  String Name;
    private  String Email;
    private  float Height;
    private  float Weight;
    private  String Gender;

    public String getImageUrl() {
        return this.ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.ImageUrl = imageUrl;
    }

    private  String ImageUrl;

    public UserDetail() {

    }

    public UserDetail(String names, String emails, float heights, float weights, String genders) {
        this.Name = names;
        this.Email = emails;
        this.Height = heights;
        this.Weight = weights;
        this.Gender = genders;

    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public float getHeight() {
        return this.Height;
    }

    public void setHeight(float height) {
        this.Height = height;
    }

    public float getWeight() {
        return this.Weight;
    }

    public void setWeight(float weight) {
        this.Weight = weight;
    }

    public String getGender() {
        return this.Gender;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }
}
