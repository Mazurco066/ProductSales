package br.edu.fatecmm.vendaprodutos.view;

import br.edu.fatecmm.vendaprodutos.business.ItemOrderBus;
import br.edu.fatecmm.vendaprodutos.business.OrderBus;
import br.edu.fatecmm.vendaprodutos.business.ProductBus;
import br.edu.fatecmm.vendaprodutos.model.ItemOrder;
import br.edu.fatecmm.vendaprodutos.model.Order;
import br.edu.fatecmm.vendaprodutos.model.Product;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/** @author Mazurco066 */
public class SalesView extends javax.swing.JInternalFrame {
    
    //Camada de Business
    protected ProductBus prodBus;
    protected OrderBus orderBus;
    protected Order order;
    protected ItemOrderBus itemList;
    protected int itemAmount = 0;
    protected double totalValue = 0.0;
    
    // <editor-fold defaultstate="collapsed" desc="Construtores">
    
    //Método Construtor Padrão
    public SalesView() {
        initComponents();
        this.prodBus = new ProductBus();
        this.order = new Order();
        this.itemList = new ItemOrderBus();
        readProducts();
        refreshItens();
        displayInfo();
        ProductTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ItemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    //Métodos Construtores com Business
    public SalesView(ProductBus pb){
        initComponents();
        this.prodBus = pb;
        this.order = new Order();
        this.itemList = new ItemOrderBus();
        readProducts();
        refreshItens();
        displayInfo();
        ProductTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ItemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public SalesView(ProductBus pb, OrderBus ob){
        initComponents();
        this.prodBus = pb;
        this.orderBus = ob;
        this.order = new Order();
        this.itemList = new ItemOrderBus();
        readProducts();
        refreshItens();
        displayInfo();
        ProductTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ItemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Métodos Gerais">
    
    /**
     * Método para centralizar tela no DesktopPane.
     */
    public void setCenter(){
        
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    
    /**
     * Método para verificar se produto selecionado ja foi adicionado
     * a venda.
     * 
     * @return 
     *      - Retorna true se sim e false se não.
     */
    private boolean isAdded(){
        
        for (int i = 0; i < ItemTable.getRowCount(); i++){
                
                if (ProductTable.getValueAt(ProductTable.getSelectedRow(), 0) == ItemTable.getValueAt(i, 0)){
                    return true;
                } 
            }
        
        return false;
    }
    
    /**
     * Método que recupera todos os produtos cadastrados
     * e os coloca na tabela de produtos no lado esquerdo
     * da tela.
     */
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
    
    /**
     * Método para ler todos os itens adicionados ao pedido
     * e atualizar a tabela com as novas atualizações de 
     * quantidade.
     */
    private void refreshItens(){
        
        DefaultTableModel modelo = (DefaultTableModel) ItemTable.getModel();
        modelo.setNumRows(0);
        
        itemList.getItemList().stream().forEach((_item) -> {
            modelo.addRow(new Object[]{
                _item.getProduct().getID(),
                _item.getProduct().getDescription(),
                _item.getAmount(),
                _item.getValue()
            });
        });
    }
    
    /**
     * Método para devolver a quantidade de itens de um
     * produto quando remover um item do pedido.
     * 
     * @param _product
     *      - Recebe o produto a ser reestocado.
     * 
     * @param amount 
     *      - Recebe a quantidade a ser reestocada.
     */
    private void refoundProduct(Product _product, int amount){
        
        for (int i = 0; i < ProductTable.getRowCount(); i++){
            
            if(_product.getID() == (int) ProductTable.getValueAt(i, 0)){
                
                ProductTable.setValueAt((int) ProductTable.getValueAt(i, 2) + amount, i, 2);
                break;
            }
        }
    }
    
    /**
     * Método que recupera o valor unitário do produto
     * selecionado.
     * 
     * @param _ID
     *      - Recebe o Id do produto selecionado.
     * 
     * @return 
     *      - Retorna seu preço.
     */
    private double getPrice(int _ID){
        
        for (int i = 0; i < ProductTable.getRowCount(); i++){
            
            if(_ID == (int) ProductTable.getValueAt(i, 0)){
                
                return (double) ProductTable.getValueAt(i, 3);
            }
        }
        
        return 0.0;
    }
    
    /**
     * Método que informa ao usuário as informações da atual compra,
     * mostra quantidade de itens, subtotal, data , etc. Simula uma
     * nota fiscál na tela de venda de produtos.
     */
    private void displayInfo(){
        
        //Definindo formatação padrão para data e ID
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder number = new StringBuilder();
        StringBuilder amount = new StringBuilder();
        StringBuilder subtotal = new StringBuilder();
        number.append(orderBus.getID());
        amount.append(itemAmount);
        subtotal.append(totalValue);
        
        //Exibindo os Dados do Pedido
        outNumber.setText(number.toString());
        outDate.setText(dateFormat.format(order.getDate()));
        outAmount.setText(amount.toString());
        outTotal.setText(subtotal.toString());
        
    }
    
    /**
     * Método que retorna os dados dessa classe a origem, 
     * ou seja, aos valores iniciais dos atributos.
     */
    private void reset(){
        
        //Resetando a Tela para uso após conclusão de uma venda ou cancelamento da mesma
        this.itemAmount = 0;
        this.totalValue = 0.0;
        this.order = new Order();
        this.itemList = new ItemOrderBus();
        readProducts();
        refreshItens();
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
        lblInst = new javax.swing.JLabel();
        btnRemoveAll = new javax.swing.JButton();
        pannelInvoice = new javax.swing.JPanel();
        lblAmount = new javax.swing.JLabel();
        outAmount = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        spInvoice = new javax.swing.JSeparator();
        outTotal = new javax.swing.JLabel();
        lblNumber = new javax.swing.JLabel();
        outNumber = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        outDate = new javax.swing.JLabel();

        setBackground(new java.awt.Color(165, 182, 211));
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaleMouseClicked(evt);
            }
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
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
        pannelAdditions.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicionar Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setText("+");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRemove.setText("-");
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveMouseClicked(evt);
            }
        });

        lblInst.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInst.setForeground(new java.awt.Color(255, 255, 255));
        lblInst.setText("Adicione ou Remova um Produto");

        btnRemoveAll.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRemoveAll.setText("X");
        btnRemoveAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveAllMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pannelAdditionsLayout = new javax.swing.GroupLayout(pannelAdditions);
        pannelAdditions.setLayout(pannelAdditionsLayout);
        pannelAdditionsLayout.setHorizontalGroup(
            pannelAdditionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelAdditionsLayout.createSequentialGroup()
                .addGroup(pannelAdditionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannelAdditionsLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lblInst))
                    .addGroup(pannelAdditionsLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveAll)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pannelAdditionsLayout.setVerticalGroup(
            pannelAdditionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelAdditionsLayout.createSequentialGroup()
                .addComponent(lblInst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelAdditionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove)
                    .addComponent(btnRemoveAll))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pannelInvoice.setBackground(getBackground());
        pannelInvoice.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nota de Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lblAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAmount.setForeground(new java.awt.Color(255, 255, 255));
        lblAmount.setText("Quantidade de Itens . . . . .");

        outAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        outAmount.setForeground(new java.awt.Color(255, 255, 255));
        outAmount.setText("0");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setText("Valor Total  . . . . . . . R$");

        outTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        outTotal.setForeground(new java.awt.Color(255, 255, 255));
        outTotal.setText("0.0");

        lblNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNumber.setForeground(new java.awt.Color(255, 255, 255));
        lblNumber.setText("Número Pedido  . . . . . . . . .");

        outNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        outNumber.setForeground(new java.awt.Color(255, 255, 255));
        outNumber.setText("0");

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("Data Emissão : ");

        outDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        outDate.setForeground(new java.awt.Color(255, 255, 255));
        outDate.setText("00/00/0000");

        javax.swing.GroupLayout pannelInvoiceLayout = new javax.swing.GroupLayout(pannelInvoice);
        pannelInvoice.setLayout(pannelInvoiceLayout);
        pannelInvoiceLayout.setHorizontalGroup(
            pannelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelInvoiceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spInvoice)
                    .addGroup(pannelInvoiceLayout.createSequentialGroup()
                        .addGroup(pannelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pannelInvoiceLayout.createSequentialGroup()
                                .addComponent(lblAmount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(outAmount))
                            .addGroup(pannelInvoiceLayout.createSequentialGroup()
                                .addComponent(lblTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(outTotal))
                            .addGroup(pannelInvoiceLayout.createSequentialGroup()
                                .addComponent(lblNumber)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(outNumber))
                            .addGroup(pannelInvoiceLayout.createSequentialGroup()
                                .addComponent(lblDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(outDate)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pannelInvoiceLayout.setVerticalGroup(
            pannelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelInvoiceLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pannelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumber)
                    .addComponent(outNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(outDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAmount)
                    .addComponent(outAmount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(outTotal))
                .addGap(26, 26, 26))
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
                    .addComponent(pannelActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pannelInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pannelAdditions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pannelInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(pannelActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // <editor-fold defaultstate="collapsed" desc="Animações">
    
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
                
                Product _product = new Product();
            
                if (isAdded()){
                    
                    //Tem - Localizando Informações do Item
                    _product.setID((int) ProductTable.getValueAt(ProductTable.getSelectedRow(), 0));                   
                    ProductTable.setValueAt((int) ProductTable.getValueAt(ProductTable.getSelectedRow(), 2) - 1, ProductTable.getSelectedRow(), 2);          
                    totalValue += (double) ProductTable.getValueAt(ProductTable.getSelectedRow(), 3);
                    
                    //Atualizando o item do pedido
                    itemList.editItem(_product);
                    
                }
                else{

                    //Não Tem - Criando Instancia de Objetos
                    ItemOrder _item = new ItemOrder();

                    //Alimentando Objetos
                    _product.setID((int) ProductTable.getValueAt(ProductTable.getSelectedRow(), 0));
                    _product.setDescription(ProductTable.getValueAt(ProductTable.getSelectedRow(), 1).toString());
                    _product.setAmount((int) ProductTable.getValueAt(ProductTable.getSelectedRow(), 2));
                    ProductTable.setValueAt((int) ProductTable.getValueAt(ProductTable.getSelectedRow(), 2) - 1, ProductTable.getSelectedRow(), 2);
                    _product.setPrice((double) ProductTable.getValueAt(ProductTable.getSelectedRow(), 3));
                    totalValue += (double) ProductTable.getValueAt(ProductTable.getSelectedRow(), 3);
                    _item.setProduct(_product);
                    _item.setAmount(1);
                    _item.setValue(_product.getPrice() * _item.getAmount());
                    
                    //Adicionando novo item para pedido
                    itemList.addItem(_item);

                }
                
                //Atualizando Tabela
                itemAmount++;
                refreshItens();
                displayInfo();
                
            }
            else{
               JOptionPane.showMessageDialog(null, "Não há mais desse produto em Estoque!"); 
            }
                 
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione Algum produto para realizar essa Ação!");
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
        // Ações Botão Delete
        if (ItemTable.getSelectedRow() != -1){
            
            Product _product = new Product();
            
            //Verificando se o item selecionado possúi mais de uma unidade
            if ((int) ItemTable.getValueAt(ItemTable.getSelectedRow(), 2) > 1){
                
                //Nesse caso so removerá uma unidade do item selecionado
                _product.setID((int) ItemTable.getValueAt(ItemTable.getSelectedRow(), 0));
                this.totalValue -= getPrice(_product.getID());
                
                //Retornando uma unidade para tabela de produtos
                refoundProduct(_product, 1);
                 
                itemList.removeItem(_product);
            }
            else{
                
                //Nesse caso removerá o item selecionado do pedido
                _product.setID((int) ItemTable.getValueAt(ItemTable.getSelectedRow(), 0));
                this.totalValue -= getPrice(_product.getID());
                
                //Retornando uma unidade para tabela de produtos
                refoundProduct(_product, 1);
                 
                itemList.removeAllItens(_product);
            }
            
            //Atualizando Tabela
            itemAmount--;
            refreshItens();
            displayInfo();
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione Algum item para realizar essa Ação!");
        }
    }//GEN-LAST:event_btnRemoveMouseClicked

    private void btnRemoveAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveAllMouseClicked
        // Ações Botão RemoveAll
        if (ItemTable.getSelectedRow() != -1){
            
            //Instanciando um produto e quantidade para transação
            Product _product = new Product();
            int amount = (int) ItemTable.getValueAt(ItemTable.getSelectedRow(), 2);
            
            //Nesse caso so removerá uma unidade do item selecionado
            _product.setID((int) ItemTable.getValueAt(ItemTable.getSelectedRow(), 0));           
                     
            //Retornando uma unidade para tabela de produtos
            refoundProduct(_product, amount);
                 
            itemList.removeAllItens(_product);
            
            //Atualizando Tabela
            itemAmount -= amount;
            this.totalValue -= getPrice(_product.getID()) * amount;
            refreshItens();
            displayInfo();
            
        }
        else{
            
            JOptionPane.showMessageDialog(null, "Selecione Algum item para realizar essa Ação!");
        }
    }//GEN-LAST:event_btnRemoveAllMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        // Ações Botão Cancelar
        int cancel = JOptionPane.showConfirmDialog(null, "Deseja Cancelar Operação?");
        
        if (cancel == 0){
            //Cancelando a Operação de Venda
            reset();
            JOptionPane.showMessageDialog(null, "Operação Cancelada por Usuário!");
        }
        
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnSaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaleMouseClicked
        // Ações Botão Realizar Pedido
        order.setID(orderBus.getID());
        orderBus.increment();
        itemList.getItemList().stream().forEach((ItemOrder _item) -> {
            Product _product = new Product();
            _product = _item.getProduct();
            _product.setAmount(_product.getAmount() - _item.getAmount());
            prodBus.editProduct(_product);
            order.addItem(_item); 
        });
        order.generateSubtotal();
        order.generateItemAmount();
        orderBus.addOrder(order);
        
        //Pedido Emitido com Sucesso
        JOptionPane.showMessageDialog(null, "Venda Realizada com Valor Total de R$" + order.getSubtotal());
        reset();
        displayInfo();
        
    }//GEN-LAST:event_btnSaleMouseClicked

    // </editor-fold>

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ItemTable;
    private javax.swing.JTable ProductTable;
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel btnCancel;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnRemoveAll;
    private javax.swing.JLabel btnSale;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblInst;
    private javax.swing.JLabel lblNumber;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel outAmount;
    private javax.swing.JLabel outDate;
    private javax.swing.JLabel outNumber;
    private javax.swing.JLabel outTotal;
    private javax.swing.JPanel pannelActions;
    private javax.swing.JPanel pannelAdditions;
    private javax.swing.JPanel pannelInvoice;
    private javax.swing.JSeparator spInvoice;
    // End of variables declaration//GEN-END:variables
}
