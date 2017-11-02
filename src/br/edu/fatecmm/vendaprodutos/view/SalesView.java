package br.edu.fatecmm.vendaprodutos.view;

import br.edu.fatecmm.vendaprodutos.business.ProductBus;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;

/** @author Mazurco066 */
public class SalesView extends javax.swing.JInternalFrame {
    
    //Camada de Business
    protected ProductBus prodBus;
    
    // <editor-fold defaultstate="collapsed" desc="Construtores">
    
    //Método Construtor Padrão
    public SalesView() {
        initComponents();
        this.prodBus = new ProductBus();
        readProducts();
    }
    
    //Método Construtor com Business
    public SalesView(ProductBus pb){
        initComponents();
        this.prodBus = pb;
        readProducts();
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
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 153, 153));
        setClosable(true);
        setTitle("Venda de Produtos");
        setPreferredSize(new java.awt.Dimension(900, 600));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(353, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ProductTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
