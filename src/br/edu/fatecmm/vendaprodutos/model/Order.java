package br.edu.fatecmm.vendaprodutos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** @author Mazurco066 */
public class Order {
    
    //Atributos
    private int ID;
    private Date date;
    private final List<ItemOrder> itens;
    
    //Método Construtor Padrão
    public Order(){
        //Inicia os objetos
        this.ID = 0;
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
    
    //Métodos de Classe
    public void addItem(ItemOrder item){
        itens.add(item);
    }
    
    public void removeItem(ItemOrder item){
        itens.remove(item);
    }
    
}
