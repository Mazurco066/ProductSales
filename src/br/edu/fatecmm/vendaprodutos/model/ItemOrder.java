package br.edu.fatecmm.vendaprodutos.model;

import java.util.Objects;

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
    
    //Método Equals e HashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.product);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemOrder other = (ItemOrder) obj;
        
        return Objects.equals(this.product, other.product);
    }
    
}
