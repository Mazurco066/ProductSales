package br.edu.fatecmm.vendaprodutos.view;

import br.edu.fatecmm.vendaprodutos.business.OrderBus;
import br.edu.fatecmm.vendaprodutos.business.ProductBus;
import br.edu.fatecmm.vendaprodutos.model.ItemOrder;
import br.edu.fatecmm.vendaprodutos.model.Order;
import br.edu.fatecmm.vendaprodutos.model.Product;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/** @author Mazurco066 */
public class SalesView extends javax.swing.JInternalFrame {
    
    //Camada de Business
    protected ProductBus prodBus;
    protected OrderBus orderBus;
    protected Order order;
    protected List<ItemOrder> itemList;
    
    // <editor-fold defaultstate="collapsed" desc="Construtores">
    
    //Método Construtor Padrão
    public SalesView() {
        initComponents();
        this.prodBus = new ProductBus();
        this.order = new Order();
        this.itemList = new ArrayList();
        readProducts();
        refreshItens();
    }
    
    //Métodos Construtores com Business
    public SalesView(ProductBus pb){
        initComponents();
        this.prodBus = pb;
        this.order = new Order();
        this.itemList = new ArrayList();
        readProducts();
        refreshItens();
    }
    
    public SalesView(ProductBus pb, OrderBus ob){
        initComponents();
        this.prodBus = pb;
        this.orderBus = ob;
        this.order = new Order();
        this.itemList = new ArrayList();
        readProducts();
        refreshItens();
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Métodos Gerais">
    
    public void setCenter(){
        
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    
    private boolean isAdded(){
        
        for (int i = 0; i < ItemTable.getRowCount(); i++){
                
                if (ProductTable.getValueAt(ProductTable.getSelectedRow(), 0) == ItemTable.getValueAt(i, 0)){
                    return true;
                } 
            }
        
        return false;
    }
    
    private void readProducts(){
        
        //Definindo o Objeto para Alimentar a Lista
        DefaultTableModel modelo = (DefaultTableModel) ProductTable.getModel();
        modelo.setNumRows(0);
        
        //Inserindo os dados na lista
        prodBus.getProducts().stream().forEach((_item) -> {
            modelo.addRow(new Object[]{
                _item.getID(),
                _item.getDescription(),
                _item.getAmount(),
                _item.getPrice()
            });
        });
    }
    
    private void refreshItens(){
        
        DefaultTableModel modelo = (DefaultTableModel) ItemTable.getModel();
        modelo.setNumRows(0);
        
        itemList.stream().forEach((_item) -> {
            modelo.addRow(new Object[]{
                _item.getProduct().getID(),
                _item.getProduct().getDescription(),
                _item.getAmount(),
                _item.getValue()
            });
        });
    }
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        ItemTable = new javax.swing.JTable();
        pannelActions = new javax.swing.JPanel();
        btnSale = new javax.swing.JLabel();
        btnCancel = new javax.swing.JLabel();
        pannelAdditions = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));
        setClosable(true);
        setTitle("Venda de Produtos");
        setPreferredSize(new java.awt.Dimension(1000, 600));

        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Descrição", "Quantidade", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ProductTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        ProductTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        ProductTable.getColumnModel().getColumn(2).setPreferredWidth(90);
        ProductTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        jScrollPane1.setViewportView(ProductTable);
        if (ProductTable.getColumnModel().getColumnCount() > 0) {
            ProductTable.getColumnModel().getColumn(0).setResizable(false);
            ProductTable.getColumnModel().getColumn(1).setResizable(false);
            ProductTable.getColumnModel().getColumn(2).setResizable(false);
            ProductTable.getColumnModel().getColumn(3).setResizable(false);
        }

        ItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Descrição", "Quantidade", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ItemTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        ItemTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        ItemTable.getColumnModel().getColumn(2).setPreferredWidth(90);
        ItemTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        jScrollPane2.setViewportView(ItemTable);
        if (ItemTable.getColumnModel().getColumnCount() > 0) {
            ItemTable.getColumnModel().getColumn(0).setResizable(false);
            ItemTable.getColumnModel().getColumn(1).setResizable(false);
            ItemTable.getColumnModel().getColumn(2).setResizable(false);
            ItemTable.getColumnModel().getColumn(3).setResizable(false);
        }

        pannelActions.setBackground(getBackground());
        pannelActions.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btnSale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSale.setForeground(new java.awt.Color(255, 255, 255));
        btnSale.setText("Realizar Pedido");
        btnSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaleMouseExited(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancelar");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pannelActionsLayout = new javax.swing.GroupLayout(pannelActions);
        pannelActions.setLayout(pannelActionsLayout);
        pannelActionsLayout.setHorizontalGroup(
            pannelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelActionsLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnSale)
                .addGap(18, 18, 18)
                .addComponent(btnCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pannelActionsLayout.setVerticalGroup(
            pannelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelActionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSale)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pannelAdditions.setBackground(getBackground());
        pannelAdditions.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btnAdd.setText("+");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnRemove.setText("-");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Adicione ou Remova um Produto");

        javax.swing.GroupLayout pannelAdditionsLayout = new javax.swing.GroupLayout(pannelAdditions);
        pannelAdditions.setLayout(pannelAdditionsLayout);
        pannelAdditionsLayout.setHorizontalGroup(
            pannelAdditionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelAdditionsLayout.createSequentialGroup()
                .addGroup(pannelAdditionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannelAdditionsLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove))
                    .addGroup(pannelAdditionsLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        pannelAdditionsLayout.setVerticalGroup(
            pannelAdditionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelAdditionsLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelAdditionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pannelAdditions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pannelActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pannelAdditions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pannelActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // <editor-fold defaultstate="collapsed" desc="Animaões">
    
    private void btnSaleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaleMouseEntered
        // Mouse Sobre Botão Vender
        btnSale.setForeground(Color.GRAY);
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnSaleMouseEntered

    private void btnSaleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaleMouseExited
        // Mouse Saindo do Botão Vender
        btnSale.setForeground(Color.white);
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnSaleMouseExited

    private void btnCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseEntered
        // Mouse sobre botão Cancelar
        btnCancel.setForeground(Color.GRAY);
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnCancelMouseEntered

    private void btnCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseExited
        // Mouse Saindo do Botão Cancelar
        btnCancel.setForeground(Color.white);
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnCancelMouseExited

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Açoes">
    
    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // Ação Botão Add
        if (ProductTable.getSelectedRow() != -1){
            
            //Verifica se há produtos em estoque para venda
            if ((int) ProductTable.getValueAt(ProductTable.getSelectedRow(), 2) > 0){
            
                if (isAdded()){
                    //Tem
                    JOptionPane.showMessageDialog(null, "Entrou aqui");
                }
                else{

                    //Não Tem - Criando Instancia de Objetos
                    ItemOrder _item = new ItemOrder();
                    Product _product = new Product();

                    //Alimentando Objetos
                    _product.setID((int) ProductTable.getValueAt(ProductTable.getSelectedRow(), 0));
                    _product.setDescription(ProductTable.getValueAt(ProductTable.getSelectedRow(), 1).toString());
                    _product.setAmount((int) ProductTable.getValueAt(ProductTable.getSelectedRow(), 2));
                    ProductTable.setValueAt((int) ProductTable.getValueAt(ProductTable.getSelectedRow(), 2) - 1, ProductTable.getSelectedRow(), 2);
                    _product.setPrice((double) ProductTable.getValueAt(ProductTable.getSelectedRow(), 3));
                    _item.setProduct(_product);
                    _item.setAmount(1);
                    _item.setValue(_product.getPrice() * _item.getAmount());
                    itemList.add(_item);

                }
                
                //Atualizando Tabela
                refreshItens();
                
            }
            else{
               JOptionPane.showMessageDialog(null, "Não há mais desse produto em Estoque!"); 
            }
                 
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione Algum produto para realizar essa Ação!");
        }
    }//GEN-LAST:event_btnAddMouseClicked

    // </editor-fold>

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ItemTable;
    private javax.swing.JTable ProductTable;
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel btnCancel;
    private javax.swing.JButton btnRemove;
    private javax.swing.JLabel btnSale;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pannelActions;
    private javax.swing.JPanel pannelAdditions;
    // End of variables declaration//GEN-END:variables
}
