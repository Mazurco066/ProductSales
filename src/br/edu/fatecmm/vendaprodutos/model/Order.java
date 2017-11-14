package br.edu.fatecmm.vendaprodutos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** @author Mazurco066 */
public class Order {
    
    //Atributos
    private int ID;
    private Date date;
    private int itemAmount;
    private double subtotal;
    private final List<ItemOrder> itens;
    
    //Método Construtor Padrão
    public Order(){
        //Inicia os objetos
        this.ID = 0;
        this.subtotal = 0.0;
        this.date = new Date();
        this.itens = new ArrayList();
    }

    //Métodos Getter e Setter
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ItemOrder> getItens() {
        return itens;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }
    
    //Método equals e HashCode
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
        final Order other = (Order) obj;
        
        return this.ID == other.ID;
    }

    @Override
    public int hashCode() {
        
        int hash = 7;
        hash = 97 * hash + this.ID;
        return hash;
    }
    
    //Métodos de Classe
    public void addItem(ItemOrder item){
        itens.add(item);
    }
    
    public void generateSubtotal(){
        
        //Zerando atributo
        subtotal = 0;
        
        //Calculando novo valor
        itens.stream().forEach((ItemOrder _item) -> {
            
            subtotal += _item.getValue();
        });
    }
    
    public void generateItemAmount(){
        
        //Zerando atributo
        itemAmount = 0;
        
        //Calculando novo valor
        itens.stream().forEach((ItemOrder _item) -> {
            
            itemAmount += _item.getAmount();
        });
    }
    
}
