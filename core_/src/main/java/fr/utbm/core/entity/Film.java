/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.core.entity;

/**
 *
 * @author mbennis
 */
public class Film {
    public String titre;
    private String genre;

    /**
     * @return
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
}
