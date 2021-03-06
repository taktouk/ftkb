/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import modeles.Historique;
import modeles.Joueur;
import modeles.Personnes;
import modeles.specialite;
import services.ServiceJoueur.*;



/**
 *
 * @author guigam
 */

public class GestionDesJoueurs {
    private Joueur lejoueur = new Joueur();
    private Personnes monPersonne = new Personnes();
    private List<Personnes> lesPersonnes = new LinkedList<Personnes>();   
    private List<Joueur> lesJoueurs = new LinkedList<Joueur>();
    private List<specialite> mesSpecial = new LinkedList<specialite>();
    private Historique m_historique = new Historique();
   
    gestionPersonnes gspersonne = (gestionPersonnes) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("gestionpersonne");

	/** Creates a new instance of GestionDesJoueurs */
    public GestionDesJoueurs() {
    }

    public List<Joueur> getlstJoueurActifs(){
    	return new ServiceJoueurImpl().ListeDesJoueurActifs();
    }
    

//    public List<Personnes> listePersonneByCIN() {
//       lesPersonnes =new gestionPersonnes().getlistePersonneByCIN(getMonPersonne().getCin());
//       monPersonne = lesPersonnes.get(0);
//       return lesPersonnes;
//    }

    public Joueur rechercheJoueurParLicence(String licence) {
    	Historique hj = new gestionHistorique().rechercheLicenceCourante(licence);
    	Date now = new Date();
    	List<Joueur> lstJoueurs = new GestionDesJoueurs().getlistDesJoueurs();
    	for(Joueur j : (List<Joueur>)lstJoueurs){
    		System.out.println(j.lsthistoriqueJoueur);
    		if(j.getLsthistoriqueJoueur().contains(hj)){
    			if (hj.getDateDebut().compareTo(now)<=0 && hj.getDateFin().compareTo(now)>=0){
    				return j;
    			}
    		}
    	}
       return null;
    }
    

      public List<Joueur>  getlistDesJoueurs(){
        return new ServiceJoueurImpl().lstJoueurs();
    }
     
 
    public String saveJoueurs() {
    	Calendar c = Calendar.getInstance();
    	c.set(3000, 11, 30);   
    	m_historique.setDateFin(c.getTime());
        Joueur monJoueur = new Joueur();
        List<Historique> lstHD = new LinkedList<Historique>();
    	lstHD.add(m_historique);
    	lejoueur.setLsthistoriqueJoueur(lstHD);       
        lejoueur.setLaPersonne(gspersonne.getLstpersonne().get(0));         
        new ServiceJoueurImpl().saveJoueur(lejoueur);
        return "listJoueurs";
    }

    public String saveJoueurEtPersonne() {
        Joueur joueur = new Joueur();
        new gestionPersonnes().enregistrerPersonne(monPersonne);
        saveJoueurs();
        return "listJoueurs";

    }
    

    /**
     * @return the lejoueur
     */
    public Joueur getLejoueur() {
        return lejoueur;
    }

    /**
     * @param lejoueur the lejoueur to set
     */
    public void setLejoueur(Joueur lejoueur) {
        this.lejoueur = lejoueur;
    }

    /**
     * @return the lesJoueurs
     */
    public List<Joueur> getLesJoueurs() {
        return lesJoueurs;
    }

    /**
     * @param lesJoueurs the lesJoueurs to set
     */
    public void setLesJoueurs(List<Joueur> lesJoueurs) {
        this.setLesJoueurs(lesJoueurs);
    }

    

    /**
     * @return the monPersonne
     */
    public Personnes getMonPersonne() {
        return monPersonne;
    }

    /**
     * @param monPersonne the monPersonne to set
     */
    public void setMonPersonne(Personnes monPersonne) {
        this.monPersonne = monPersonne;
    }

    /**
     * @return the lesPersonnes
     */
    public List<Personnes> getLesPersonnes() {
        return lesPersonnes;
    }

    /**
     * @param lesPersonnes the lesPersonnes to set
     */
    public void setLesPersonnes(List<Personnes> lesPersonnes) {
        this.setLesPersonnes(lesPersonnes);
    }


    /**
     * @return the mesSpecial
     */
    public List<specialite> getMesSpecial() {
        return mesSpecial;
    }

    /**
     * @param mesSpecial the mesSpecial to set
     */
    public void setMesSpecial(List<specialite> mesSpecial) {
        this.mesSpecial = mesSpecial;
    }

    
    public Historique getM_historique() {
		return m_historique;
	}


	public void setM_historique(Historique m_historique) {
		this.m_historique = m_historique;
	}

}
