package com.example.durma.idj.Model;

/**
 * Created by durma on 1.3.18..
 */

public class Emisije {
    private int image;
    private String title;

    public Emisije(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public Emisije() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
