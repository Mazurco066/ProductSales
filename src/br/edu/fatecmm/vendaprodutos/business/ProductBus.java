package br.edu.fatecmm.vendaprodutos.business;

import br.edu.fatecmm.vendaprodutos.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/** @author Mazurco066 */
public class ProductBus {
    
    //Atributos
    private int ID;
    private final List<Product> products;
    
    //Método Construtor
    public ProductBus(){
        
        this.ID = 1;
        this.products = new ArrayList();
    }
    
    //Métodos Getter e Setter
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<Product> getProducts() {
        return products;
    }
    
    //Business Methods
    public void increment(){
        this.ID++;
    }
    
    public void addProduct(Product p){
        this.products.add(p);
        JOptionPane.showMessageDialog(null, "Produto Adicionado!");
    }
    
    public void editProduct(Product p){
        
        products.stream().forEach((Product _item) ->{
            
            if (p.getID() == _item.getID()){
                
                _item.setDescription(p.getDescription());
                _item.setAmount(p.getAmount());
                _item.setPrice(p.getPrice());
                
            }
        });
       
    }
    
    public void deleteProduct(Product p){
        
        for(Product _item: products){
            
            if (p.getID() == _item.getID()){
                
                products.remove(_item);
                break;
                
            }
        }
    }
    
    public List<Product> searchProducts(String search){
        
        List<Product> resultSet = new ArrayList();
        
        products.stream().forEach((Product _item) ->{
            
            if (_item.getDescription().contains(search)){
                
                resultSet.add(_item);
            }
        });
        
        return resultSet;
    }
    
    public boolean isValidID(int id){
        
        return products.stream().noneMatch((p) -> (p.getID() == id));
    }
}
