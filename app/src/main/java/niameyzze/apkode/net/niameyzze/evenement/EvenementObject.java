package niameyzze.apkode.net.niameyzze.evenement;

import java.io.Serializable;

/**
 * Created by brabo on 6/2/16.
 */
public class EvenementObject implements Serializable{
    private String categorie;
    private String rubrique;
    private String titre;
    private String tarif;
    private String lieu;
    private String presentation;
    private String image;
    private String horaire;

    public EvenementObject(String categorie, String rubrique, String titre, String tarif, String lieu, String presentation, String image, String horaire) {
        this.categorie = categorie;
        this.rubrique = rubrique;
        this.titre = titre;
        this.tarif = tarif;
        this.lieu = lieu;
        this.presentation = presentation;
        this.image = image;
        this.horaire = horaire;
    }

    public EvenementObject() {
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getRubrique() {
        return rubrique;
    }

    public void setRubrique(String rubrique) {
        this.rubrique = rubrique;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }
}
