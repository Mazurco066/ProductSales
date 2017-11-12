package br.edu.fatecmm.vendaprodutos.view;

import br.edu.fatecmm.vendaprodutos.business.ProductBus;
import br.edu.fatecmm.vendaprodutos.model.Product;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/** @author Mazurco066 */
public class ProductView extends javax.swing.JInternalFrame {
    
    //Product Bus Object
    protected ProductBus bus;
    
    // <editor-fold defaultstate="collapsed" desc="Construtores">
    
    //Construtor padrão
    public ProductView() {
        initComponents();
        read();
        ProductTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    //Construtor customizado para receber o bus de produtos
    public ProductView(ProductBus pb) {
        initComponents();
        this.bus = pb;
        read();
        ProductTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Métodos Gerais"> 
    
    //Método Centralizador
    
    /**
     * Método que centraliza tela no DesktopPane.
     */
    public void setCenter(){
        
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    
    //Método Validador de Campos
    
    /**
     * Método que valida se os campos de preenchimento
     * obrigatórios estão devidamente preenchidos.
     * 
     * @return 
     *      - Retorna true se estiver tudo ok e false 
     *      se algum campo necessitar de preenchimento.
     */
    private boolean isValidFields(){
        
        return !(
                    txtPrice.getText().equals("") ||
                    txtAmount.getText().equals("Quantidade") ||
                    txtDesc.getText().equals("") ||
                    txtDesc.getText().equals("Descrição Produto") ||
                    txtAmount.getText().equals("") ||
                    txtPrice.getText().equals("Valor Unitário")
               );
        
    }
    
    /**
     * Método que verifica se os campos obrigatórios
     * numéricos foram devidamente preenchidos com números.
     * 
     * @return 
     *      - Retorna true se tudo estiver válido e false
     *      se estiver inválido.
     */
    private boolean isValidNumbers(){
        
        try{
            Integer.parseInt(txtAmount.getText());
            Double.parseDouble(txtPrice.getText());
        }
        catch(NumberFormatException e){
            
            return false;
        }
        
        if (Integer.parseInt(txtAmount.getText()) < 0) return false;
        return Double.parseDouble(txtPrice.getText()) >= 0;
            
    }
    
    /**
     * Método que Limpa as caixas de texto presentes
     * nesse formulário.
     */
    private void clear(){
        
        /*
        //Esse trecho não deve ser utilizado por prédefinições de texto nas JTextFields
        for (Component item : this.getContentPane().getComponents()) {
            
            if(item instanceof JTextField){
                
                JTextField obj = (JTextField) item;
                obj.setText("");
            }
        }*/
        
        //Setando novamente as pré-definições
        txtDesc.setText("Descrição Produto");
        txtAmount.setText("Quantidade");
        txtPrice.setText("Valor Unitário");
    }
    
    /**
     * Método que recupera todos os produtos cadastrados e os mostra
     * em uma tabela de produtos localizado na parte de baixo do
     * formulário.
     */
    private void read(){
        
        //Definindo o Objeto para Alimentar a Lista
        DefaultTableModel modelo = (DefaultTableModel) ProductTable.getModel();
        modelo.setNumRows(0);
        
        //Inserindo os dados na lista
        bus.getProducts().stream().forEach((_item) -> {
            modelo.addRow(new Object[]{
                _item.getID(),
                _item.getDescription(),
                _item.getAmount(),
                _item.getPrice()
            });
        });
        
    }
    
    /**
     * Método que recupera produtos cadastrados que 
     * se encaixam com a busca feita pelo usuário.
     * 
     * @param search
     *      - Recebe a String de busca informada pelo
     *      usuário.
     */
    private void readForDesc(String search){
        
        //Definindo o Objeto para Alimentar a Lista
        DefaultTableModel modelo = (DefaultTableModel) ProductTable.getModel();
        modelo.setNumRows(0);
        
        //Inserindo os dados na lista
        bus.searchProducts(search).stream().forEach((_item) -> {
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
        txtSearch = new javax.swing.JTextField();
        spSearch = new javax.swing.JSeparator();
        txtDesc = new javax.swing.JTextField();
        spDesc = new javax.swing.JSeparator();
        txtAmount = new javax.swing.JTextField();
        spAmount = new javax.swing.JSeparator();
        txtPrice = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        buttonsPannel = new javax.swing.JPanel();
        btnAdd = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();

        setBackground(new java.awt.Color(165, 182, 211));
        setClosable(true);
        setTitle("Cadastro de Produtos");

        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Descrição", "Quantidade", "Valor Unitário"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProductTable);
        if (ProductTable.getColumnModel().getColumnCount() > 0) {
            ProductTable.getColumnModel().getColumn(0).setResizable(false);
            ProductTable.getColumnModel().getColumn(1).setResizable(false);
            ProductTable.getColumnModel().getColumn(2).setResizable(false);
            ProductTable.getColumnModel().getColumn(3).setResizable(false);
        }

        txtSearch.setBackground(getBackground());
        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch.setText("Buscar Produto");
        txtSearch.setToolTipText("Buscar Produto");
        txtSearch.setBorder(null);
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        spSearch.setBackground(new java.awt.Color(255, 255, 255));
        spSearch.setForeground(new java.awt.Color(255, 255, 255));

        txtDesc.setBackground(getBackground());
        txtDesc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDesc.setForeground(new java.awt.Color(255, 255, 255));
        txtDesc.setText("Descrição Produto");
        txtDesc.setToolTipText("Descrição Produto");
        txtDesc.setBorder(null);
        txtDesc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescFocusLost(evt);
            }
        });

        spDesc.setBackground(new java.awt.Color(255, 255, 255));
        spDesc.setForeground(new java.awt.Color(255, 255, 255));

        txtAmount.setBackground(getBackground());
        txtAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAmount.setForeground(new java.awt.Color(255, 255, 255));
        txtAmount.setText("Quantidade");
        txtAmount.setToolTipText("Quantidade");
        txtAmount.setBorder(null);
        txtAmount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAmountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAmountFocusLost(evt);
            }
        });

        spAmount.setBackground(new java.awt.Color(255, 255, 255));
        spAmount.setForeground(new java.awt.Color(255, 255, 255));

        txtPrice.setBackground(getBackground());
        txtPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(255, 255, 255));
        txtPrice.setText("Valor Unitário");
        txtPrice.setToolTipText("Valor Unitário");
        txtPrice.setBorder(null);
        txtPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPriceFocusLost(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        buttonsPannel.setBackground(getBackground());
        buttonsPannel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Adicionar");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddMouseExited(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Alterar");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditMouseExited(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Excluir");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout buttonsPannelLayout = new javax.swing.GroupLayout(buttonsPannel);
        buttonsPannel.setLayout(buttonsPannelLayout);
        buttonsPannelLayout.setHorizontalGroup(
            buttonsPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPannelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonsPannelLayout.setVerticalGroup(
            buttonsPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonsPannelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(buttonsPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(buttonsPannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {spDesc, txtDesc});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {spAmount, txtAmount});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jSeparator1, txtPrice});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonsPannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(spSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // <editor-fold defaultstate="collapsed" desc="Animações"> 
    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        // Evento Para Ganho de Foco txtSearch
        if (txtSearch.getText().equals("Buscar Produto")){
            //Remove o texto atual
            txtSearch.setText("");
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        // Evento para Perda de Foco txtSearch
        if (txtSearch.getText().equals("") || txtSearch.getText().equals(" ")){
            //Adiciona o texto sugestivo novamente
            txtSearch.setText("Buscar Produto");
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtDescFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescFocusGained
        // Evento Para Ganho de Foco txtDesc
        if (txtDesc.getText().equals("Descrição Produto")){
            //Remove o texto atual
            txtDesc.setText("");
        }
    }//GEN-LAST:event_txtDescFocusGained

    private void txtDescFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescFocusLost
        // Evento para Perda de Foco txtDesc
        if (txtDesc.getText().equals("") || txtDesc.getText().equals(" ")){
            //Adiciona o texto sugestivo novamente
            txtDesc.setText("Descrição Produto");
        }
    }//GEN-LAST:event_txtDescFocusLost

    private void txtAmountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAmountFocusGained
        // Evento para Ganho de Foco txtAmount
        if (txtAmount.getText().equals("Quantidade")){
            //Remove o texto atual
            txtAmount.setText("");
        }
    }//GEN-LAST:event_txtAmountFocusGained

    private void txtAmountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAmountFocusLost
        // Evento para Perda de Foco txtamount
        if (txtAmount.getText().equals("") || txtAmount.getText().equals(" ")){
            //Adiciona o texto sugestivo novamente
            txtAmount.setText("Quantidade");
        }
    }//GEN-LAST:event_txtAmountFocusLost

    private void txtPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusGained
        // Evento para Ganho de Foco txtPrice
        if (txtPrice.getText().equals("Valor Unitário")){
            //Remove o texto atual
            txtPrice.setText("");
        }
    }//GEN-LAST:event_txtPriceFocusGained

    private void txtPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPriceFocusLost
        // Evento para Perda de Foco txtPrice
        if (txtPrice.getText().equals("") || txtPrice.getText().equals(" ")){
            //Adiciona o texto sugestivo novamente
            txtPrice.setText("Valor Unitário");
        }
    }//GEN-LAST:event_txtPriceFocusLost

    private void btnAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseEntered
        // Mouse sobre btnAdd
        btnAdd.setForeground(Color.GRAY);
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnAddMouseEntered

    private void btnAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseExited
        // Mouse saindo do btnAdd
        btnAdd.setForeground(Color.white);
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnAddMouseExited

    private void btnEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseEntered
        // Mouse sobre btnEdit
        btnEdit.setForeground(Color.GRAY);
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnEditMouseEntered

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
        // Mouse saindo do btnEdit
        btnEdit.setForeground(Color.white);
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnEditMouseExited

    private void btnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseEntered
        // Mouse sobre btnDelete
        btnDelete.setForeground(Color.GRAY);
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnDeleteMouseEntered

    private void btnDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseExited
        // Mouse saindo do btnDelete
        btnDelete.setForeground(Color.white);
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnDeleteMouseExited

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Açoes de Botões"> 
    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // Ações do botão Adicionar
        if (isValidFields()){
            
            if (isValidNumbers()){
                
                //Todos os campos estão devidamente Preenchidos - Instanciando e Alimentando os dados do produto
                Product product = new Product();
                product.setID(bus.getID());
                product.setDescription(txtDesc.getText());
                product.setAmount(Integer.parseInt(txtAmount.getText()));
                product.setPrice(Double.parseDouble(txtPrice.getText()));

                //Acionando a Classe business para adicionar o produto
                bus.addProduct(product);
                bus.increment();    //Auto incremento para ID

                //Limpando os Campos e Atualizando tabela
                clear();
                read();
                
                //Mensagem de Sucesso
                JOptionPane.showMessageDialog(null, "Produto Adicionado!");
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Preencha Corretamente Quantidade e Valor Unitário com NÚMEROS!");
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos antes de realizar essa Ação!");
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        // Ações do botão editar
        if (ProductTable.getSelectedRow() != -1){
            
            if (isValidFields()){
            
                if (isValidNumbers()){

                    //Todos os campos estão devidamente Preenchidos - Instanciando e Alimentando os dados do produto
                    Product product = new Product();
                    product.setID((int)ProductTable.getValueAt(ProductTable.getSelectedRow(), 0));
                    product.setDescription(txtDesc.getText());
                    product.setAmount(Integer.parseInt(txtAmount.getText()));
                    product.setPrice(Double.parseDouble(txtPrice.getText()));

                    //Acionando a Classe business para adicionar o produto
                    bus.editProduct(product);

                    //Limpando os Campos e Atualizando tabela
                    clear();
                    read();
                    
                    //Mensagem de Sucesso
                    JOptionPane.showMessageDialog(null, "Produto Atualizado!");

                }
                else{
                    JOptionPane.showMessageDialog(null, "Preencha Corretamente Quantidade e Valor Unitário com NÚMEROS!");
                }

            }
            else{
                JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos antes de realizar essa Ação!");
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione Algum produto para realizar essa Ação!");
        }
        
    }//GEN-LAST:event_btnEditMouseClicked

    private void ProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductTableMouseClicked
        // Ao Clicar em algum produto na tabela
        if (ProductTable.getSelectedRow() != -1){
                        
            txtDesc.setText(ProductTable.getValueAt(ProductTable.getSelectedRow(), 1).toString());
            txtAmount.setText(ProductTable.getValueAt(ProductTable.getSelectedRow(), 2).toString());
            txtPrice.setText(ProductTable.getValueAt(ProductTable.getSelectedRow(), 3).toString());
        }
    }//GEN-LAST:event_ProductTableMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // Ações do Botão Delete
        if (ProductTable.getSelectedRow() != -1){

            Product product = new Product();
            product.setID((int)ProductTable.getValueAt(ProductTable.getSelectedRow(), 0));

            //Acionando a Classe business para adicionar o produto
            bus.deleteProduct(product);
            
            //Limpando os Campos e Atualizando tabela
            clear();
            read();
            
            //Mensagem de Sucesso
            JOptionPane.showMessageDialog(null, "Produto Deletado!");
     
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione Algum produto para realizar essa Ação!");
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        // Evento de Busca de Produtos
        readForDesc(txtSearch.getText());
    }//GEN-LAST:event_txtSearchKeyTyped
    
    // </editor-fold>

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ProductTable;
    private javax.swing.JLabel btnAdd;
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JPanel buttonsPannel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator spAmount;
    private javax.swing.JSeparator spDesc;
    private javax.swing.JSeparator spSearch;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
