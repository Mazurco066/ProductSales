package br.edu.fatecmm.vendaprodutos.business;

import br.edu.fatecmm.vendaprodutos.model.Product;
import java.util.ArrayList;
import java.util.List;

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
    
    /**
     * Método para incrementar ID dessa classe bus.
     * ID autoincrementável é um dos recursos que esse
     * sistema possúi.
     */
    public void increment(){
        this.ID++;
    }
    
    /**
     * Método para adicionar um produto ao estoque.
     * 
     * @param p 
     *      - Recebe o produto que deve ser adicionado.
     */
    public void addProduct(Product p){
        this.products.add(p);
    }
    
    /**
     * Método para alterar produtos presente no estoque.
     * 
     * @param p 
     *      - Recebe o produto que deve ser alterado.
     */
    public void editProduct(Product p){
        
        products.stream().forEach((Product _item) ->{
            
            if (p.equals(_item)){
            
                _item.setDescription(p.getDescription());
                _item.setAmount(p.getAmount());
                _item.setPrice(p.getPrice());
                
            }
        });
       
    }
    
    /**
     * Remove um produto do estoque.
     * 
     * @param p
     *      -Recebe o produto que deve ser removido.
     */
    public void deleteProduct(Product p){
        
        if (products.contains(p)) products.remove(p);
        
    }
    
    /**
     * Método que prodcura por produtos no estoque que
     * contenham o texto digitado pelo usuário como busca
     * e os retornam em forma de lista para exibição.
     * 
     * @param search
     *      - Recebe a String de busca entrada pelo usuário.
     * 
     * @return 
     *      - Retorna uma lista com os produtos encontrados.
     */
    public List<Product> searchProducts(String search){
        
        List<Product> resultSet = new ArrayList();
        
        products.stream().forEach((Product _item) ->{
            
            if (_item.getDescription().contains(search)){
                
                resultSet.add(_item);
            }
        });
        
        return resultSet;
    }
    
    /**
     * Método que verifica se o id informado se refere a algum
     * produto já cadastrado.
     * 
     * @param id
     *      - Recebe o id do produto a ser buscado.
     * 
     * @return
     *      - Retorna true se válido e false se inválido.
     */
    public boolean isValidID(int id){
        
        return products.stream().noneMatch((p) -> (p.getID() == id));
    }
}
