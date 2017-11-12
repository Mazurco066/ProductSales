package br.edu.fatecmm.vendaprodutos.view;

import br.edu.fatecmm.vendaprodutos.business.OrderBus;
import br.edu.fatecmm.vendaprodutos.model.ItemOrder;
import br.edu.fatecmm.vendaprodutos.model.Order;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/** @author Mazurco066 */
public class OrderView extends javax.swing.JInternalFrame {
    
    //Atributos
    protected OrderBus bus;
    
    // <editor-fold defaultstate="collapsed" desc="Construtores">
    
    //Método Construtor Padrão
    public OrderView() {
        initComponents();
        this.bus = new OrderBus();
        readOrders();
        clearItens();
        OrderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }
    
    //Método Construtor Personalizado
    public OrderView(OrderBus bus){
        initComponents();
        this.bus = bus;
        readOrders();
        clearItens();
        OrderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Métodos Gerais">
    
    /**
     * Método para centralizar form no DesktopPane.
     */
    public void setCenter(){
        
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    
    /**
     * Método para validar se ha texto no campo de busca.
     * 
     * @return 
     *      - Retorna true se a validação for valida e false se resultar
     *      em inválida. 
     */
    private boolean isValidSearch(){
        
        return !(txtOrderID.getText().equals("Digite ID do Pedido Aqui") || txtOrderID.getText().equals(""));
    }
    
    /**
     * Método para verificar se buscas que se deseja
     * realizar é de formato numérico.
     * 
     * @return 
     *      - Retorna true se válido e false se inválido.
     */
    private boolean isNumberSearch(){
        
        try{
            Integer.parseInt(txtOrderID.getText());
        }
        catch(NumberFormatException e){
            return false;
        }
        
        return Integer.parseInt(txtOrderID.getText()) >= 0;
    }
    
    /**
     * Método que preenche a tabela com todos os pedidos realizados
     * no sistema no menu de vendas.
     */
    private void readOrders(){
        
        DefaultTableModel modelo = (DefaultTableModel) OrderTable.getModel();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        modelo.setNumRows(0);
        
        bus.getOrders().stream().forEach((Order _item) -> {
            modelo.addRow(new Object[]{
                _item.getID(),
                dateFormat.format(_item.getDate()),
                "R$ " + _item.getSubtotal()
            });
        });
        
    }
    
    /**
     * Método para Limpar a tabela de itens de pedidos
     * reaalizados.
     */
    private void clearItens(){
        
        DefaultTableModel modelo = (DefaultTableModel) ItemTable.getModel();
        modelo.setNumRows(0);
    }
    
    /**
     * Método para preencher a tabela de itens com com
     * os itens presentes no pedido selecionado pelo
     * usuário.
     * 
     * @param order
     *      - Recebe o pedido no qual se deseja verificar
     *      os itens presentes.
     */
    private void readItens(Order order){
        
        DefaultTableModel modelo = (DefaultTableModel) ItemTable.getModel();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder number = new StringBuilder();
        StringBuilder amount = new StringBuilder();
        StringBuilder price = new StringBuilder();
        modelo.setNumRows(0);
        
        //Convertendo Números em texto
        number.append(order.getID());
        amount.append(order.getItemAmount());
        price.append(order.getSubtotal());
        
        //Adicionando Valores as labels
        outID.setText(number.toString());
        outDate.setText(dateFormat.format(order.getDate()));
        outAmount.setText(amount.toString());
        outTotal.setText(price.toString());
        
        //Adicionando itens a tabela de itens
        order.getItens().stream().forEach((ItemOrder _item) -> {
            modelo.addRow(new Object[]{
                _item.getProduct().getID(),
                _item.getProduct().getDescription(),
                _item.getProduct().getPrice(),
                _item.getAmount(),
                _item.getValue()
            });
        });
    }
    
    /**
     * Método que recupera um pedido indormando seu ID.
     * 
     * @param ID
     *      - Recebe o ID do pedido a ser buscado.
     * 
     * @return 
     *      - Retorna o pedido encontrado caso contrário
     *      não retornará nada.
     */
    private Order getOrder(int ID){
        
        for (Order _item: bus.getOrders()){
            
            if (_item.getID() == ID) return _item;
            
        }
             
        return null;
    }
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();
        pannelInstructions = new javax.swing.JPanel();
        lblInst02 = new javax.swing.JLabel();
        lblInst01 = new javax.swing.JLabel();
        lblInst03 = new javax.swing.JLabel();
        lblInst4 = new javax.swing.JLabel();
        spSplitter2 = new javax.swing.JSeparator();
        txtOrderID = new javax.swing.JTextField();
        spOrderID = new javax.swing.JSeparator();
        btnSearch = new javax.swing.JLabel();
        spSplitter = new javax.swing.JSeparator();
        lblID = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        outID = new javax.swing.JLabel();
        outDate = new javax.swing.JLabel();
        outAmount = new javax.swing.JLabel();
        outTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ItemTable = new javax.swing.JTable();
        lblItens = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Selecione um pedido da tabela ");

        setBackground(new java.awt.Color(165, 182, 211));
        setClosable(true);
        setTitle("Consultar Pedidos");
        setPreferredSize(new java.awt.Dimension(700, 600));

        OrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Data", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        OrderTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        OrderTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        OrderTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        OrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(OrderTable);
        if (OrderTable.getColumnModel().getColumnCount() > 0) {
            OrderTable.getColumnModel().getColumn(0).setResizable(false);
            OrderTable.getColumnModel().getColumn(1).setResizable(false);
            OrderTable.getColumnModel().getColumn(2).setResizable(false);
        }

        pannelInstructions.setBackground(getBackground());
        pannelInstructions.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecionar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lblInst02.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblInst02.setForeground(new java.awt.Color(255, 255, 255));
        lblInst02.setText("ao lado para ver quais foram");

        lblInst01.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblInst01.setForeground(new java.awt.Color(255, 255, 255));
        lblInst01.setText("Selecione um pedido da tabela ");

        lblInst03.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblInst03.setForeground(new java.awt.Color(255, 255, 255));
        lblInst03.setText("os itens vendidos.");

        lblInst4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblInst4.setForeground(new java.awt.Color(255, 255, 255));
        lblInst4.setText("Ou entre com ID do Pedido:");

        txtOrderID.setBackground(getBackground());
        txtOrderID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtOrderID.setForeground(new java.awt.Color(255, 255, 255));
        txtOrderID.setText("Digite ID do Pedido Aqui");
        txtOrderID.setBorder(null);
        txtOrderID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtOrderIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOrderIDFocusLost(evt);
            }
        });

        spOrderID.setBackground(new java.awt.Color(255, 255, 255));
        spOrderID.setForeground(new java.awt.Color(255, 255, 255));

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Buscar");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pannelInstructionsLayout = new javax.swing.GroupLayout(pannelInstructions);
        pannelInstructions.setLayout(pannelInstructionsLayout);
        pannelInstructionsLayout.setHorizontalGroup(
            pannelInstructionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelInstructionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelInstructionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spSplitter2)
                    .addComponent(txtOrderID)
                    .addGroup(pannelInstructionsLayout.createSequentialGroup()
                        .addGroup(pannelInstructionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInst02)
                            .addComponent(lblInst03)
                            .addComponent(lblInst4))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addComponent(spOrderID))
                .addContainerGap())
            .addGroup(pannelInstructionsLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(btnSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pannelInstructionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pannelInstructionsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblInst01)
                    .addContainerGap(10, Short.MAX_VALUE)))
        );
        pannelInstructionsLayout.setVerticalGroup(
            pannelInstructionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelInstructionsLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblInst02)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInst03)
                .addGap(7, 7, 7)
                .addComponent(spSplitter2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInst4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(pannelInstructionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pannelInstructionsLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(lblInst01)
                    .addContainerGap(134, Short.MAX_VALUE)))
        );

        lblID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblID.setText("ID Pedido");

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDate.setText("Data do Pedido");

        lblAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAmount.setText("Quantidade de Itens");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotal.setText("Total da Venda");

        outID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        outID.setForeground(new java.awt.Color(255, 255, 255));
        outID.setText("0");

        outDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        outDate.setForeground(new java.awt.Color(255, 255, 255));
        outDate.setText("00/00/0000");

        outAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        outAmount.setForeground(new java.awt.Color(255, 255, 255));
        outAmount.setText("0");

        outTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        outTotal.setForeground(new java.awt.Color(255, 255, 255));
        outTotal.setText("R$ 00,00");

        ItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Produto", "Descrição", "Valor Unitário", "Quantidade", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ItemTable.getColumnModel().getColumn(0).setPreferredWidth(80);
        ItemTable.getColumnModel().getColumn(1).setPreferredWidth(220);
        ItemTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        ItemTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        ItemTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        jScrollPane2.setViewportView(ItemTable);
        if (ItemTable.getColumnModel().getColumnCount() > 0) {
            ItemTable.getColumnModel().getColumn(0).setResizable(false);
            ItemTable.getColumnModel().getColumn(1).setResizable(false);
            ItemTable.getColumnModel().getColumn(2).setResizable(false);
            ItemTable.getColumnModel().getColumn(3).setResizable(false);
            ItemTable.getColumnModel().getColumn(4).setResizable(false);
        }

        lblItens.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblItens.setText("Itens Relacionados com o Pedido Selecionado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(outID, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDate)
                        .addGap(64, 64, 64)
                        .addComponent(lblAmount)
                        .addGap(62, 62, 62)
                        .addComponent(lblTotal)
                        .addGap(51, 51, 51))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(outDate)
                        .addGap(143, 143, 143)
                        .addComponent(outAmount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(outTotal)
                        .addGap(70, 70, 70))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spSplitter)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pannelInstructions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblItens)
                .addGap(186, 186, 186))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pannelInstructions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spSplitter, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(lblDate)
                    .addComponent(lblAmount)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outID)
                    .addComponent(outDate)
                    .addComponent(outAmount)
                    .addComponent(outTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblItens)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Animações">
    
    private void txtOrderIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOrderIDFocusGained
        // Evento caixa de texto de ID ao ganhar foco
        if (txtOrderID.getText().equals("Digite ID do Pedido Aqui")){
            //Remove o texto atual
            txtOrderID.setText("");
        }
    }//GEN-LAST:event_txtOrderIDFocusGained

    private void txtOrderIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOrderIDFocusLost
        // Evento caixa de texto de ID ao perder foco
        if (txtOrderID.getText().equals("") || txtOrderID.getText().equals(" ")){
            //Adiciona o texto sugestivo novamente
            txtOrderID.setText("Digite ID do Pedido Aqui");
        }
    }//GEN-LAST:event_txtOrderIDFocusLost

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        // Evento mouse sobre botão buscar
        btnSearch.setForeground(Color.GRAY);
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnSearchMouseEntered

    private void btnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseExited
        // Evento mouse saindo botão buscar
        btnSearch.setForeground(Color.white);
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnSearchMouseExited

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Ações">
    
    private void OrderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderTableMouseClicked
        // Evento de Selecionar pedido na tabela
        if (OrderTable.getSelectedRow() != -1){
            
            Order o = getOrder((int) OrderTable.getValueAt(OrderTable.getSelectedRow(), 0));
            
            if (o != null){
                
                readItens(o);
            }
        }
    }//GEN-LAST:event_OrderTableMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        // Evento de buscar Pedido Manualmente
        
        //Verifica se os dados entrados pelo usuário não estão vazios
        if (isValidSearch()){
            
            //Verifica se os dados entrados pelo usuário contem somente números
            if (isNumberSearch()){
                
                //Tentando recuperar o pedido requisitado pelo usuário
                Order o = getOrder(Integer.parseInt(txtOrderID.getText()));
                
                //Verifica se o mesmo é válido
                if (o != null){
                    
                    //Todos os Campos validados e ID digitado é válido prosseguindo com o retorno dos dados do pedido
                    readItens(o);
                }
                else{
                    //Mensagem de Retorno
                    JOptionPane.showMessageDialog(null ,"O ID Digitado é Inválido!");
                }
            }
            else{
                //Mensagem de Retorno
                JOptionPane.showMessageDialog(null ,"O campo de busca não foi preenchido corretamente com um número!");
            }
            
        }
        else{
            //Mensagem de Retorno
            JOptionPane.showMessageDialog(null ,"O campo de busca não foi preenchido!");
        }
    }//GEN-LAST:event_btnSearchMouseClicked

    // </editor-fold>

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ItemTable;
    private javax.swing.JTable OrderTable;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblInst01;
    private javax.swing.JLabel lblInst02;
    private javax.swing.JLabel lblInst03;
    private javax.swing.JLabel lblInst4;
    private javax.swing.JLabel lblItens;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel outAmount;
    private javax.swing.JLabel outDate;
    private javax.swing.JLabel outID;
    private javax.swing.JLabel outTotal;
    private javax.swing.JPanel pannelInstructions;
    private javax.swing.JSeparator spOrderID;
    private javax.swing.JSeparator spSplitter;
    private javax.swing.JSeparator spSplitter2;
    private javax.swing.JTextField txtOrderID;
    // End of variables declaration//GEN-END:variables
}
