package br.edu.fatecmm.vendaprodutos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** @author Mazurco066 */
public class Order {
    
    //Atributos
    private int ID;
    private Date date;
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
    
    //Métodos de Classe
    public void addItem(ItemOrder item){
        itens.add(item);
    }
    
    public void generateSubtotal(){
        
        itens.stream().forEach((ItemOrder _item) -> {
            
            subtotal += _item.getValue();
        });
    }
    
}
