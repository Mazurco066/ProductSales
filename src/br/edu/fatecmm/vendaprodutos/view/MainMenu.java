/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fatecmm.vendaprodutos.view;

import br.edu.fatecmm.vendaprodutos.business.OrderBus;
import br.edu.fatecmm.vendaprodutos.business.ProductBus;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/** @author Mazurco066 */
public class MainMenu extends javax.swing.JFrame {
    
    //Atributos
    protected ProductBus bus;
    protected OrderBus oBus;
    
    public MainMenu() {
        initComponents();
        this.bus = new ProductBus();
        this.oBus = new OrderBus();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        //ImageIcon icon = new ImageIcon(getClass().getResource("../images/background.png"));
        //Image image = icon.getImage();
        painelInterno = new javax.swing.JDesktopPane(){

            /*
            Ativar esse fragmento de código caso desejar utilizar a imagem como background
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
            */
        };
        btnSearch = new javax.swing.JLabel();
        btnProduct = new javax.swing.JLabel();
        btnSales = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        lblCredits = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setPreferredSize(new java.awt.Dimension(1024, 700));
        setResizable(false);

        painelInterno.setBackground(new java.awt.Color(86, 116, 165));

        btnSearch.setFont(new java.awt.Font("Roboto Th", 1, 48)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Consultas");
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

        btnProduct.setFont(new java.awt.Font("Roboto Th", 1, 48)); // NOI18N
        btnProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnProduct.setText("Produtos");
        btnProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProductMouseExited(evt);
            }
        });

        btnSales.setFont(new java.awt.Font("Roboto Th", 1, 48)); // NOI18N
        btnSales.setForeground(new java.awt.Color(255, 255, 255));
        btnSales.setText("Vendas");
        btnSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalesMouseExited(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Roboto Th", 1, 36)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Sair");
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });

        lblCredits.setFont(new java.awt.Font("Roboto Th", 1, 18)); // NOI18N
        lblCredits.setForeground(new java.awt.Color(255, 255, 255));
        lblCredits.setText("Developed by Gabriel Mazurco Ribeiro");

        painelInterno.setLayer(btnSearch, javax.swing.JLayeredPane.DEFAULT_LAYER);
        painelInterno.setLayer(btnProduct, javax.swing.JLayeredPane.DEFAULT_LAYER);
        painelInterno.setLayer(btnSales, javax.swing.JLayeredPane.DEFAULT_LAYER);
        painelInterno.setLayer(btnExit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        painelInterno.setLayer(lblCredits, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout painelInternoLayout = new javax.swing.GroupLayout(painelInterno);
        painelInterno.setLayout(painelInternoLayout);
        painelInternoLayout.setHorizontalGroup(
            painelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInternoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(painelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCredits)
                    .addGroup(painelInternoLayout.createSequentialGroup()
                        .addComponent(btnProduct)
                        .addGap(18, 18, 18)
                        .addComponent(btnSales)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addContainerGap())
        );
        painelInternoLayout.setVerticalGroup(
            painelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelInternoLayout.createSequentialGroup()
                .addContainerGap(485, Short.MAX_VALUE)
                .addGroup(painelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExit)
                    .addGroup(painelInternoLayout.createSequentialGroup()
                        .addGroup(painelInternoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnProduct)
                            .addComponent(btnSearch)
                            .addComponent(btnSales))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCredits)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelInterno)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelInterno)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // <editor-fold defaultstate="collapsed" desc="Animações dos Botóes"> 
    private void btnProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductMouseEntered
        // Evento de mouse sobre o botão produtos
        btnProduct.setForeground(Color.lightGray);
        btnProduct.setFont(new Font("Roboto th", Font.BOLD, 56));
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnProductMouseEntered

    private void btnProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductMouseExited
        // Evento de mouse sair da seleção do botão produtos
        btnProduct.setForeground(Color.white);
        btnProduct.setFont(new Font("Roboto th", Font.BOLD, 48));
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnProductMouseExited

    private void btnSalesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalesMouseEntered
        // Evento de mouse sobre o botão vendas
        btnSales.setForeground(Color.lightGray);
        btnSales.setFont(new Font("Roboto th", Font.BOLD, 56));
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnSalesMouseEntered

    private void btnSalesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalesMouseExited
        // Evento de mouse sair da seleção do botão vendas
        btnSales.setForeground(Color.white);
        btnSales.setFont(new Font("Roboto th", Font.BOLD, 48));
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnSalesMouseExited

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        // Evento de mouse sobre o botão busca
        btnSearch.setForeground(Color.lightGray);
        btnSearch.setFont(new Font("Roboto th", Font.BOLD, 56));
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnSearchMouseEntered

    private void btnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseExited
        // Evento de mouse sair da seleção do botão busca
        btnSearch.setForeground(Color.white);
        btnSearch.setFont(new Font("Roboto th", Font.BOLD, 48));
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnSearchMouseExited

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        // Evento de mouse sobre o botão sair
        btnExit.setForeground(Color.lightGray);
        btnExit.setFont(new Font("Roboto th", Font.BOLD, 48));
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        // Evento de mouse sair da seleção do botão exit
        btnExit.setForeground(Color.white);
        btnExit.setFont(new Font("Roboto th", Font.BOLD, 36));
        this.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnExitMouseExited
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Ações dos Botóes"> 
    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // Código para o botão sair
        this.dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductMouseClicked
        // Código para o botão produtos
        ProductView view = new ProductView(bus);
        painelInterno.add(view);
        view.setVisible(true);
        view.setBorder(BorderFactory.createLineBorder(Color.lightGray, 4));
        view.setCenter();
    }//GEN-LAST:event_btnProductMouseClicked

    private void btnSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalesMouseClicked
        // Código para o botão vendas
        SalesView sales = new SalesView(bus, oBus);
        painelInterno.add(sales);
        sales.setVisible(true);
        sales.setBorder(BorderFactory.createLineBorder(Color.lightGray, 4));
        sales.setCenter();
    }//GEN-LAST:event_btnSalesMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        // Código botão Consultas
        OrderView order = new OrderView(oBus);
        painelInterno.add(order);
        order.setVisible(true);
        order.setBorder(BorderFactory.createLineBorder(Color.lightGray, 4));
        order.setCenter();
    }//GEN-LAST:event_btnSearchMouseClicked
    // </editor-fold>
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnProduct;
    private javax.swing.JLabel btnSales;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JLabel lblCredits;
    private javax.swing.JDesktopPane painelInterno;
    // End of variables declaration//GEN-END:variables
}
