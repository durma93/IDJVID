package com.example.durma.idj.Model;



/**
 * Created by durma on 26.2.18..
 */

public class Video {

    private int slika;
    private String naziv;
    private String broj_pregleda;

    public Video() {
    }

    public Video(int slika, String naziv, String broj_pregleda) {
        this.slika = slika;
        this.naziv = naziv;
        this.broj_pregleda = broj_pregleda;
    }

    public int getSlika() {
        return slika;
    }

    public void setSlika(int slika) {
        this.slika = slika;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getBroj_pregleda() {
        return broj_pregleda;
    }

    public void setBroj_pregleda(String broj_pregleda) {
        this.broj_pregleda = broj_pregleda;
    }
}
