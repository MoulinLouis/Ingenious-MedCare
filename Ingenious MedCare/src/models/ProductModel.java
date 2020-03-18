package models;

public class ProductModel {
 
    private int id;
    private String nom;
    private String classification;
    private String substance;
    private String excipient;
    private String conservation;
    private String libelle;
    
    public ProductModel(int id, String nom, String classification, String substance, String excipient, String conservation, String libelle)
    {
        this.id = id;
        this.nom = nom;
        this.classification = classification;
        this.substance = substance;
        this.excipient = excipient;
        this.conservation = conservation;
        this.libelle = libelle;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getNom()
    {
        return nom;
    }
    
    public String getClassification()
    {
        return classification;
    }
    
    public String getSubstance()
    {
    	return substance;
    }
    
    public String getExcipient()
    {
        return excipient;
    }
    
    public String getConservation()
    {
    	return conservation;
    
    }
    
    public String getLibelle()
    {
    	return libelle;
    
    }
}