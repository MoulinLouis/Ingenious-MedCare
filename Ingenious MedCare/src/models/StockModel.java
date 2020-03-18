package models;

public class StockModel {
	
    private int id;
    private String nom;
    private int quantity; 
    
    public StockModel(int id, String nom, int quantity)
    {
        this.id = id;
        this.nom = nom;
        this.quantity = quantity;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getNom()
    {
        return nom;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
}