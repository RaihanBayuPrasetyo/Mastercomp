package umn.ac.id.uas.project.model;

public class ComputerPackage {
    private String title, description, ranking;
    private int image;
    private double price;

    public ComputerPackage(String title, double price, String description, int image, String ranking) {
        this.title = title;
        this.description = description;
        this.ranking = ranking;
        this.image = image;
        this.price = price;
    }

    public String getRanking() {
        return ranking;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }
}
