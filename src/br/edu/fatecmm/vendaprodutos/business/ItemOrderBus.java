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
    
    /**
     * Método para adicionar um produto para a lista
     * de item-pedido.
     * 
     * @param _item 
     *      - Recebe o item que deve ser adicionado.
     */
    public void addItem(ItemOrder _item){
        
        itemList.add(_item);
    }
    
    /**
     * Método para alterar um item presente nessa lista.
     * 
     * @param _product 
     *      - Recebe o item do tipo produto que deve ser alterado.
     */
    public void editItem(Product _product){
        
        itemList.stream().forEach((ItemOrder _item) -> {
            
            if (_product.equals(_item.getProduct())){
                
                _item.setAmount(_item.getAmount() + 1);
                _item.setValue(_item.getAmount() * _item.getProduct().getPrice());
            }
        });
      
    }
    
    /**
     * Método que remove um item da lista de itens (quantidade) a
     * serem vendidos.
     * 
     * @param _product
     *      - Recebe o item do tipo produto que deve ser removido.
     */
    public void removeItem(Product _product){
        
        for(ItemOrder _item: itemList){
            
            if (_product.equals(_item.getProduct())){
                
                _item.setAmount(_item.getAmount() - 1);
                _item.setValue(_item.getAmount() * _item.getProduct().getPrice());
                break;
            }
        }
    }
    
    /**
     * Remove todos os itens de um produto assim o removendo
     * completamente da venda. (Todos os itens dessa instancia).
     * 
     * @param _product 
     *      - recebe o item do tipo produto a ser removido.
     */
    public void removeAllItens(Product _product){
        
        for(ItemOrder _item: itemList){
            
            if (_product.equals(_item.getProduct())){
                
                itemList.remove(_item);
                break;
            }
        }
    }
 
}
