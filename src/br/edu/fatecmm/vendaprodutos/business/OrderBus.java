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
    
    /**
     * Método para incrementar ID dessa classe bus.
     * ID autoincrementável é um dos recursos que esse
     * sistema possúi.
     */
    public void increment(){
        this.ID++;
    }
    
    /**
     * Método que armazena pedidos feitos no sistema.
     * 
     * @param order 
     *      - Recebe o pedido que deve ser adicionado.
     */
    public void addOrder(Order order){
        orders.add(order);
    }
    
}
