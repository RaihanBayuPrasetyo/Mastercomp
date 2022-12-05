package umn.ac.id.uas.project.model;

public class ProcessorIntelModel {
    private int image;
    private String description;

    public ProcessorIntelModel(int image, String description) {
        this.image = image;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
