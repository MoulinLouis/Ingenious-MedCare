package models;

public class OrdersModel {

    private int id;
    private String nom;
    private int quantity;
    private String orderDate;
    private String status;
    
    public OrdersModel(int id, String nom, int quantity, String orderDate, String status)
    {
        this.id = id;
        this.nom = nom;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.status = status;
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
    
    public String getOrderDate()
    {
        return orderDate;
    }
    
    public String getStatus()
    {
    	return status;
    
    }
}