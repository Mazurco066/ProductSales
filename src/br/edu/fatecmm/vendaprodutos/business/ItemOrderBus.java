package br.edu.fatecmm.vendaprodutos.business;

import br.edu.fatecmm.vendaprodutos.model.ItemOrder;
import br.edu.fatecmm.vendaprodutos.model.Product;
import java.util.ArrayList;
import java.util.List;

/** @author Mazurco066 */
public class ItemOrderBus {
    
    //Atributos
    private final List<ItemOrder> itemList;
    
    //Método Construtor
    public ItemOrderBus(){
        
        this.itemList = new ArrayList();
    }
    
    //Método Getter

    public List<ItemOrder> getItemList() {
        return itemList;
    }
    
    //Métodos de Negócio
    public void addItem(ItemOrder _item){
        
        itemList.add(_item);
    }
    
    public void editItem(Product _product){
        
        itemList.stream().forEach((ItemOrder _item) -> {
            
            if (_product.getID() == _item.getProduct().getID()){
                
                _item.setAmount(_item.getAmount() + 1);
                _item.setValue(_item.getAmount() * _item.getProduct().getPrice());
            }
        });
      
    }
    
    public void removeItem(Product _product){
        
        for(ItemOrder _item: itemList){
            
            if (_product.getID() == _item.getProduct().getID()){
                
                _item.setAmount(_item.getAmount() - 1);
                _item.setValue(_item.getAmount() * _item.getProduct().getPrice());
                break;
            }
        }
    }
    
    public void removeAllItens(Product _product){
        
        for(ItemOrder _item: itemList){
            
            if (_product.getID() == _item.getProduct().getID()){
                
                itemList.remove(_item);
                break;
            }
        }
    }
 
}
