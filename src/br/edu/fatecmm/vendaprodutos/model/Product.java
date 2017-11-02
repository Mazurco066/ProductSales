package br.edu.fatecmm.vendaprodutos.model;

/** @author Mazurco066 */
public class Product {
    
    //Atributos
    private int ID;
    private String description;
    private int amount;
    private double price;
    
    //Método Construtor
    public Product(){
        
        //Inicializando com Valores padrões
        this.ID = 0;
        this.description = "";
        this.amount = 0;
        this.price = 0.0;
    }
    
    //Métodos Getter e Setter
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
