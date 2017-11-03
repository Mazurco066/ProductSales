package br.edu.fatecmm.vendaprodutos.model;

/** @author Mazurco066 */
public class ItemOrder {
    
    //Atributos
    private Product product;
    private int amount;
    private double value;
    
    //Construtor Padrão
    public ItemOrder(){
        
        this.product = null;
        this.amount = 0;
        this.value = 0.0;
    }
    
    //Métodos Getter e Setter
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    
}
