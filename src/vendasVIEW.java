/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Pedro
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.awt.*;

public class vendasVIEW extends javax.swing.JFrame {

    private JTable tabelaVendas;
    private DefaultTableModel modeloTabela;
    private JScrollPane scrollPane;
    private JLabel labelTitulo;
    private JButton btnVoltar;
    private ProdutosDAO produtosDAO;

    public vendasVIEW() {
        produtosDAO = new ProdutosDAO();
        configurarTela();
        carregarProdutosVendidos();
    }

    private void configurarTela() {
        setTitle("Consultar Vendas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        labelTitulo = new JLabel("Produtos Vendidos", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Lucida Fax", Font.PLAIN, 18));
        add(labelTitulo, BorderLayout.NORTH);

        // Configuração da tabela
        modeloTabela = new DefaultTableModel(new Object[]{"ID", "Nome", "Valor"}, 0);
        tabelaVendas = new JTable(modeloTabela);
        tabelaVendas.setBackground(new Color(245, 245, 245)); 
        tabelaVendas.setFont(new Font("Arial", Font.PLAIN, 14));
        tabelaVendas.setRowHeight(25);
        tabelaVendas.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tabelaVendas.getTableHeader().setBackground(new Color(220, 220, 220));
        scrollPane = new JScrollPane(tabelaVendas);
        add(scrollPane, BorderLayout.CENTER);

        // Botão Voltar
        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> dispose());
        JPanel panelBotoes = new JPanel();
        panelBotoes.add(btnVoltar);
        panelBotoes.setBackground(Color.WHITE);
        add(panelBotoes, BorderLayout.SOUTH);
    }
    
    private void carregarProdutosVendidos() {
        modeloTabela.setRowCount(0); 

        ArrayList<ProdutosDTO> produtosVendidos = produtosDAO.listarProdutosVendidos();

        for (ProdutosDTO produto : produtosVendidos) {
            modeloTabela.addRow(new Object[]{
                produto.getId(),
                produto.getNome(),
                produto.getValor()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
       public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new vendasVIEW().setVisible(true);
        });
    }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

