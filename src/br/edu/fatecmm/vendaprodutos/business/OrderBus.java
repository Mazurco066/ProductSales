package br.edu.fatecmm.vendaprodutos.business;

import br.edu.fatecmm.vendaprodutos.model.Order;
import java.util.ArrayList;
import java.util.List;

/** @author Mazurco066 */
public class OrderBus {
    
    //Atributos
    private int ID;
    private final List<Order> orders;
    
    //Método Construtor Padrão
    public OrderBus(){
        
        this.ID = 1;
        this.orders = new ArrayList();
    }
    
    //Métodos Getter e Setter
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<Order> getOrders() {
        return orders;
    }
    
    //Métodos de Negócio
    public void addOroder(Order order){
        orders.add(order);
    }
    
}
