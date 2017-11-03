package br.edu.fatecmm.vendaprodutos.view;

import br.edu.fatecmm.vendaprodutos.business.OrderBus;
import br.edu.fatecmm.vendaprodutos.business.ProductBus;
import br.edu.fatecmm.vendaprodutos.model.Order;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;

/** @author Mazurco066 */
public class SalesView extends javax.swing.JInternalFrame {
    
    //Camada de Business
    protected ProductBus prodBus;
    protected OrderBus orderBus;
    protected Order order;
    
    // <editor-fold defaultstate="collapsed" desc="Construtores">
    
    //Método Construtor Padrão
    public SalesView() {
        initComponents();
        this.prodBus = new ProductBus();
        this.order = new Order();
        readProducts();
        readItens();
    }
    
    //Métodos Construtores com Business
    public SalesView(ProductBus pb){
        initComponents();
        this.prodBus = pb;
        this.order = new Order();
        readProducts();
        readItens();
    }
    
    public SalesView(ProductBus pb, OrderBus ob){
        initComponents();
        this.prodBus = pb;
        this.orderBus = ob;
        this.order = new Order();
        readProducts();
        readItens();
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Métodos Gerais">
    
    public void setCenter(){
        
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
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
    
    private void readItens(){
        
        //Definindo o Objeto para Alimentar a Lista
        DefaultTableModel modelo = (DefaultTableModel) ItemTable.getModel();
        modelo.setNumRows(0);
        
        //Inserindo os dados na lista
        order.getItens().stream().forEach((_item) -> {
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ItemTable;
    private javax.swing.JTable ProductTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
