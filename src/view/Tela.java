package view;

import javax.swing.JOptionPane;
import dao.ClienteDAO;
import dao.NotaFiscalDAO;
import model.Cliente;
import dao.ProdutoDAO;
import java.sql.ResultSet;
import model.Produto;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.ItemNF;
import model.NotaFiscal;

public class Tela extends javax.swing.JFrame {

    public Tela() {
        initComponents();
        listarClientes();
        listarProdutos();
        listarNotasTabela();
    }

    public void listarClientes() {

        try {

            ClienteDAO dao = new ClienteDAO();

            ArrayList<Cliente> lista
                    = dao.listar();

            DefaultTableModel modelo
                    = (DefaultTableModel) tabelaClientes.getModel();

            modelo.setRowCount(0);

            for (Cliente cliente : lista) {

                modelo.addRow(new Object[]{
                    cliente.getIdCliente(),
                    cliente.getNome(),
                    cliente.getCpf(),
                    cliente.getEndereco(),
                    cliente.getEmail()
                });
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao listar clientes: "
                    + e.getMessage()
            );

            e.printStackTrace();
        }
    }

    public void listarProdutos() {

        try {

            ProdutoDAO dao = new ProdutoDAO();

            ArrayList<Produto> lista
                    = dao.listar();

            DefaultTableModel modelo
                    = (DefaultTableModel) tabelaProdutos.getModel();

            modelo.setRowCount(0);

            for (Produto produto : lista) {

                modelo.addRow(new Object[]{
                    produto.getIdProduto(),
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getTipo(),
                    produto.getValor(),
                    produto.getQuantidade()
                });
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao listar produtos: "
                    + e.getMessage()
            );

            e.printStackTrace();
        }
    }

    public void listarNotasTabela() {

        try {

            NotaFiscalDAO dao = new NotaFiscalDAO();
            ResultSet rs = dao.listarNotas();

            DefaultTableModel modelo = (DefaultTableModel) tabelaNotaFiscal.getModel();

            modelo.setRowCount(0); // limpa tabela

            while (rs.next()) {

                modelo.addRow(new Object[]{
                    rs.getString("data_emissao"),
                    rs.getInt("id_nf"),
                    rs.getString("nome_cliente"),
                    rs.getInt("id_produto"),
                    rs.getString("nome_produto"),
                    rs.getString("descricao"),
                    rs.getInt("quantidade"),
                    rs.getDouble("valor_unitario"),
                    rs.getInt("quantidade") * rs.getDouble("valor_unitario")
                    
                });
            }

        } catch (Exception e) {

            System.out.println("Erro tabela: " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SistemaVendas = new javax.swing.JTabbedPane();
        PainelHome = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cadastrarnf = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        txtIdProduto = new javax.swing.JTextField();
        btnCadastrarNF = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        cadastrarnf1 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtDtEmissaoB = new javax.swing.JTextField();
        txtIdClienteB = new javax.swing.JTextField();
        txtIdProdutoB = new javax.swing.JTextField();
        btnAtualizarNF = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtQuantidadeB = new javax.swing.JTextField();
        txtValorB = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtIdNF = new javax.swing.JTextField();
        btnBuscarNF = new javax.swing.JToggleButton();
        btnEmitirNF = new javax.swing.JButton();
        PainelClientes = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnCadastrarCliente = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtNomeEditar = new javax.swing.JTextField();
        btnConsultarCliente = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCpfEditar = new javax.swing.JTextField();
        txtEnderecoEditar = new javax.swing.JTextField();
        txtEmailEditar = new javax.swing.JTextField();
        btnAtualizarCliente = new javax.swing.JButton();
        btnExcluirCliente = new javax.swing.JButton();
        PainelProduto = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        txtDescricaoProduto = new javax.swing.JTextField();
        txtTipoProduto = new javax.swing.JTextField();
        txtValorProduto = new javax.swing.JTextField();
        btnCadastrarProduto = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txtQuantidadeProduto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtIdProdutoEditar = new javax.swing.JTextField();
        btnConsultarProduto = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNomeProdutoEditar = new javax.swing.JTextField();
        txtDescricaoProdutoEditar = new javax.swing.JTextField();
        txtTipoProdutoEditar = new javax.swing.JTextField();
        btnAtualizarProduto = new javax.swing.JButton();
        btnExcluirProduto = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtValorProdutoEditar = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtQuantidadeProdutoEditar = new javax.swing.JTextField();
        PainelNotaFiscal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaNotaFiscal = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel21.setText("Bem-vindo ao seu Sistema de Vendas!");

        jLabel24.setText("Emita Notas-Fiscais eletrônicas de maneira simples e rápida!");

        jLabel25.setText("Conte também com um sistema completo para cadastrar Produtos e Clientes.");

        cadastrarnf.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar Nova NF"));

        jLabel33.setText("ID do Cliente");

        jLabel34.setText("ID do Produto");

        btnCadastrarNF.setText("Cadastrar");
        btnCadastrarNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarNFActionPerformed(evt);
            }
        });

        jLabel36.setText("Quantidade");

        jLabel37.setText("Valor");

        txtQuantidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtQuantidadeMouseExited(evt);
            }
        });
        txtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeActionPerformed(evt);
            }
        });
        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyReleased(evt);
            }
        });

        txtValor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtValor.setEnabled(false);
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cadastrarnfLayout = new javax.swing.GroupLayout(cadastrarnf);
        cadastrarnf.setLayout(cadastrarnfLayout);
        cadastrarnfLayout.setHorizontalGroup(
            cadastrarnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarnfLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cadastrarnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrarnfLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCadastrarNF))
                    .addGroup(cadastrarnfLayout.createSequentialGroup()
                        .addGroup(cadastrarnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(cadastrarnfLayout.createSequentialGroup()
                                .addGroup(cadastrarnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel33))
                                .addGap(39, 39, 39)
                                .addGroup(cadastrarnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(cadastrarnfLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cadastrarnfLayout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 85, Short.MAX_VALUE)))
                .addContainerGap())
        );
        cadastrarnfLayout.setVerticalGroup(
            cadastrarnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarnfLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(cadastrarnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrarnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrarnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrarnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(btnCadastrarNF)
                .addContainerGap())
        );

        cadastrarnf1.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar NF"));

        jLabel38.setText("Data de Emissão");

        jLabel39.setText("ID do Cliente");

        jLabel40.setText("ID do Produto");

        txtDtEmissaoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDtEmissaoBActionPerformed(evt);
            }
        });

        btnAtualizarNF.setText("Atualizar");
        btnAtualizarNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarNFActionPerformed(evt);
            }
        });

        jLabel42.setText("Quantidade");

        jLabel43.setText("Valor");

        jLabel26.setText("ID da NF");

        btnBuscarNF.setText("Buscar");
        btnBuscarNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNFActionPerformed(evt);
            }
        });

        btnEmitirNF.setText("Emitir NF");
        btnEmitirNF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirNFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cadastrarnf1Layout = new javax.swing.GroupLayout(cadastrarnf1);
        cadastrarnf1.setLayout(cadastrarnf1Layout);
        cadastrarnf1Layout.setHorizontalGroup(
            cadastrarnf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarnf1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cadastrarnf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarnf1Layout.createSequentialGroup()
                        .addGroup(cadastrarnf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel39)
                            .addComponent(jLabel38)
                            .addComponent(jLabel43)
                            .addComponent(jLabel42))
                        .addGap(22, 22, 22)
                        .addGroup(cadastrarnf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValorB, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantidadeB, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDtEmissaoB, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdProdutoB, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdClienteB, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cadastrarnf1Layout.createSequentialGroup()
                                .addComponent(txtIdNF, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarNF))))
                    .addComponent(jLabel26))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrarnf1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEmitirNF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizarNF)
                .addContainerGap())
        );
        cadastrarnf1Layout.setVerticalGroup(
            cadastrarnf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarnf1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(cadastrarnf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtIdNF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarNF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrarnf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtDtEmissaoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrarnf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtIdClienteB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrarnf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtIdProdutoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrarnf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(txtQuantidadeB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrarnf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txtValorB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(cadastrarnf1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizarNF)
                    .addComponent(btnEmitirNF))
                .addContainerGap())
        );

        javax.swing.GroupLayout PainelHomeLayout = new javax.swing.GroupLayout(PainelHome);
        PainelHome.setLayout(PainelHomeLayout);
        PainelHomeLayout.setHorizontalGroup(
            PainelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelHomeLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(PainelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24)
                    .addComponent(jLabel21)
                    .addGroup(PainelHomeLayout.createSequentialGroup()
                        .addComponent(cadastrarnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(cadastrarnf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        PainelHomeLayout.setVerticalGroup(
            PainelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelHomeLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addGap(48, 48, 48)
                .addGroup(PainelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cadastrarnf1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cadastrarnf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        cadastrarnf.getAccessibleContext().setAccessibleDescription("");

        SistemaVendas.addTab("Home", PainelHome);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Clientes Cadastrados");

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "CPF", "Endereço", "E-mail"
            }
        ));
        jScrollPane3.setViewportView(tabelaClientes);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar Cliente"));

        jLabel12.setText("Nome");

        jLabel13.setText("CPF");

        jLabel14.setText("Endereço");

        jLabel15.setText("E-mail");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        btnCadastrarCliente.setText("Cadastrar");
        btnCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastrarCliente)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastrarCliente)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar Cliente"));

        jLabel16.setText("Nome");

        btnConsultarCliente.setText("Consultar");
        btnConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarClienteActionPerformed(evt);
            }
        });

        jLabel17.setText("CPF");

        jLabel18.setText("Endereço");

        jLabel19.setText("E-mail");

        btnAtualizarCliente.setText("Atualizar");
        btnAtualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarClienteActionPerformed(evt);
            }
        });

        btnExcluirCliente.setText("Excluir");
        btnExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 143, Short.MAX_VALUE)
                        .addComponent(btnExcluirCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizarCliente))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNomeEditar, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEnderecoEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(txtEmailEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtCpfEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConsultarCliente)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultarCliente)
                    .addComponent(jLabel17)
                    .addComponent(txtCpfEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtEnderecoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtEmailEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirCliente)
                    .addComponent(btnAtualizarCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PainelClientesLayout = new javax.swing.GroupLayout(PainelClientes);
        PainelClientes.setLayout(PainelClientesLayout);
        PainelClientesLayout.setHorizontalGroup(
            PainelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelClientesLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(PainelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PainelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        PainelClientesLayout.setVerticalGroup(
            PainelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelClientesLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel11)
                .addGap(8, 8, 8)
                .addGroup(PainelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelClientesLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SistemaVendas.addTab("Clientes", PainelClientes);

        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Descrição", "Tipo", "Valor", "Quantidade"
            }
        ));
        jScrollPane2.setViewportView(tabelaProdutos);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Produtos Cadastrados");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar Produto"));

        jLabel1.setText("Nome");

        jLabel3.setText("Descrição");

        jLabel4.setText("Tipo");

        jLabel5.setText("Valor");

        txtTipoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoProdutoActionPerformed(evt);
            }
        });

        btnCadastrarProduto.setText("Cadastrar");
        btnCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarProdutoActionPerformed(evt);
            }
        });

        jLabel22.setText("Quantidade");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4))
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(8, 8, 8)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtQuantidadeProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(txtDescricaoProduto, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTipoProduto, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtValorProduto, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(114, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(222, Short.MAX_VALUE)
                .addComponent(btnCadastrarProduto)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrarProduto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar Produto"));

        jLabel6.setText("ID");

        btnConsultarProduto.setText("Consultar");
        btnConsultarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarProdutoActionPerformed(evt);
            }
        });

        jLabel7.setText("Nome");

        jLabel8.setText("Descrição");

        jLabel9.setText("Tipo");

        btnAtualizarProduto.setText("Atualizar");
        btnAtualizarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarProdutoActionPerformed(evt);
            }
        });

        btnExcluirProduto.setText("Excluir");
        btnExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirProdutoActionPerformed(evt);
            }
        });

        jLabel10.setText("Valor");

        jLabel23.setText("Quantidade");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcluirProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizarProduto))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtIdProdutoEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addGap(20, 20, 20)
                                .addComponent(btnConsultarProduto))
                            .addComponent(txtNomeProdutoEditar)
                            .addComponent(txtDescricaoProdutoEditar)
                            .addComponent(txtTipoProdutoEditar)
                            .addComponent(txtValorProdutoEditar)
                            .addComponent(txtQuantidadeProdutoEditar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdProdutoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnConsultarProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNomeProdutoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDescricaoProdutoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTipoProdutoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtValorProdutoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtQuantidadeProdutoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtualizarProduto)
                    .addComponent(btnExcluirProduto)))
        );

        javax.swing.GroupLayout PainelProdutoLayout = new javax.swing.GroupLayout(PainelProduto);
        PainelProduto.setLayout(PainelProdutoLayout);
        PainelProdutoLayout.setHorizontalGroup(
            PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelProdutoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        PainelProdutoLayout.setVerticalGroup(
            PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelProdutoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PainelProdutoLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        SistemaVendas.addTab("Produtos", PainelProduto);

        PainelNotaFiscal.setPreferredSize(new java.awt.Dimension(800, 400));

        tabelaNotaFiscal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data de Emissão", "ID da NF", "Nome do Cliente", "ID do Produto", "Nome do Produto", "Descrição", "Quantidade", "Valor do Produto", "Valor Final"
            }
        ));
        jScrollPane1.setViewportView(tabelaNotaFiscal);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Notas Fiscais Emitidas");

        jButton10.setText("Emitir NF");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelNotaFiscalLayout = new javax.swing.GroupLayout(PainelNotaFiscal);
        PainelNotaFiscal.setLayout(PainelNotaFiscalLayout);
        PainelNotaFiscalLayout.setHorizontalGroup(
            PainelNotaFiscalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelNotaFiscalLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(PainelNotaFiscalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PainelNotaFiscalLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        PainelNotaFiscalLayout.setVerticalGroup(
            PainelNotaFiscalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelNotaFiscalLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(PainelNotaFiscalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        SistemaVendas.addTab("Nota Fiscal", PainelNotaFiscal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SistemaVendas, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SistemaVendas, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarProdutoActionPerformed
        try {

            Produto produto = new Produto();

            produto.setNome(
                    txtNomeProduto.getText());

            produto.setDescricao(
                    txtDescricaoProduto.getText());

            produto.setTipo(
                    txtTipoProduto.getText());

            produto.setValor(
                    Double.parseDouble(
                            txtValorProduto.getText()));

            ProdutoDAO dao = new ProdutoDAO();

            dao.cadastrar(produto);

            listarProdutos();

            txtNomeProduto.setText("");
            txtDescricaoProduto.setText("");
            txtTipoProduto.setText("");
            txtValorProduto.setText("");

            JOptionPane.showMessageDialog(
                    null,
                    "Produto cadastrado!"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Erro: " + e.getMessage()
            );

            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCadastrarProdutoActionPerformed

    private void btnConsultarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarProdutoActionPerformed

        try {

            int id = Integer.parseInt(
                    txtIdProdutoEditar.getText());

            ProdutoDAO dao = new ProdutoDAO();

            Produto produto
                    = dao.consultar(id);

            if (produto != null) {

                txtNomeProdutoEditar.setText(
                        produto.getNome());

                txtDescricaoProdutoEditar.setText(
                        produto.getDescricao());

                txtTipoProdutoEditar.setText(
                        produto.getTipo());

                txtValorProdutoEditar.setText(
                        String.valueOf(
                                produto.getValor()));

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Produto não encontrado!"
                );
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Erro: " + e.getMessage()
            );

            e.printStackTrace();
        }
    }//GEN-LAST:event_btnConsultarProdutoActionPerformed

    private void btnAtualizarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarProdutoActionPerformed

        try {

            Produto produto = new Produto();

            produto.setIdProduto(
                    Integer.parseInt(
                            txtIdProdutoEditar.getText()));

            produto.setNome(
                    txtNomeProdutoEditar.getText());

            produto.setDescricao(
                    txtDescricaoProdutoEditar.getText());

            produto.setTipo(
                    txtTipoProdutoEditar.getText());

            produto.setValor(
                    Double.parseDouble(
                            txtValorProdutoEditar.getText()));

            ProdutoDAO dao = new ProdutoDAO();

            dao.atualizar(produto);

            listarProdutos();

            JOptionPane.showMessageDialog(
                    null,
                    "Produto atualizado!"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Erro: " + e.getMessage()
            );

            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAtualizarProdutoActionPerformed

    private void btnCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarClienteActionPerformed

        try {

            Cliente cliente = new Cliente();

            cliente.setNome(
                    txtNome.getText());

            cliente.setCpf(
                    txtCpf.getText());

            cliente.setEndereco(
                    txtEndereco.getText());

            cliente.setEmail(
                    txtEmail.getText());

            ClienteDAO dao = new ClienteDAO();

            dao.cadastrar(cliente);

            listarClientes();

            txtNome.setText("");
            txtCpf.setText("");
            txtEndereco.setText("");
            txtEmail.setText("");

            JOptionPane.showMessageDialog(
                    null,
                    "Cliente cadastrado!"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Erro: " + e.getMessage()
            );

            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCadastrarClienteActionPerformed

    private void btnConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarClienteActionPerformed

        try {

            String cpf = txtCpfEditar.getText();

            ClienteDAO dao = new ClienteDAO();

            Cliente cliente = dao.consultar(cpf);

            if (cliente != null) {

                txtNomeEditar.setText(
                        cliente.getNome());

                txtEnderecoEditar.setText(
                        cliente.getEndereco());

                txtEmailEditar.setText(
                        cliente.getEmail());

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Cliente não encontrado!"
                );
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Erro: " + e.getMessage()
            );

            e.printStackTrace();
        }
    }//GEN-LAST:event_btnConsultarClienteActionPerformed

    private void btnAtualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarClienteActionPerformed

        try {

            Cliente cliente = new Cliente();

            cliente.setCpf(
                    txtCpfEditar.getText());

            cliente.setNome(
                    txtNomeEditar.getText());

            cliente.setEndereco(
                    txtEnderecoEditar.getText());

            cliente.setEmail(
                    txtEmailEditar.getText());

            ClienteDAO dao = new ClienteDAO();

            dao.atualizar(cliente);

            JOptionPane.showMessageDialog(
                    null,
                    "Cliente atualizado!"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Erro: " + e.getMessage()
            );

            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAtualizarClienteActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

    }//GEN-LAST:event_jButton10ActionPerformed

    private void txtTipoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoProdutoActionPerformed

    }//GEN-LAST:event_txtTipoProdutoActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed

    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirClienteActionPerformed

        try {

            String cpf
                    = txtCpfEditar.getText();

            ClienteDAO dao
                    = new ClienteDAO();

            dao.excluir(cpf);

            listarClientes();

            JOptionPane.showMessageDialog(
                    null,
                    "Cliente excluído!"
            );

            txtNomeEditar.setText("");
            txtCpfEditar.setText("");
            txtEnderecoEditar.setText("");
            txtEmailEditar.setText("");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Erro: " + e.getMessage()
            );

            e.printStackTrace();
        }
    }//GEN-LAST:event_btnExcluirClienteActionPerformed

    private void btnExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirProdutoActionPerformed

        try {

            int id = Integer.parseInt(
                    txtIdProdutoEditar.getText());

            ProdutoDAO dao
                    = new ProdutoDAO();

            dao.excluir(id);

            listarProdutos();

            txtIdProdutoEditar.setText("");
            txtNomeProdutoEditar.setText("");
            txtDescricaoProdutoEditar.setText("");
            txtTipoProdutoEditar.setText("");
            txtValorProdutoEditar.setText("");

            JOptionPane.showMessageDialog(
                    null,
                    "Produto excluído!"
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Erro: " + e.getMessage()
            );

            e.printStackTrace();
        }
    }//GEN-LAST:event_btnExcluirProdutoActionPerformed

    private void btnCadastrarNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarNFActionPerformed
        try {
            
            NotaFiscalDAO notaFiscalDao = new NotaFiscalDAO();
            ProdutoDAO produtoDao = new ProdutoDAO();
            String idProduto = txtIdProduto.getText();
            Produto produto = produtoDao.consultar(Integer.parseInt(idProduto));
            NotaFiscal notafiscal = new NotaFiscal();
            notafiscal.setIdCliente(Integer.parseInt(txtIdCliente.getText()));

            NotaFiscalDAO dao = new NotaFiscalDAO();
            int idNF = dao.cadastrarNF(notafiscal);

            ItemNF item = new ItemNF();
            item.setIdNF(idNF);
            item.setValorUnitario(produto.getValor());
            item.setIdProduto(Integer.parseInt(txtIdProduto.getText()));
            item.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
            
            notaFiscalDao.listarNotas();
            dao.inserirItem(item);

            txtIdCliente.setText("");
            txtIdProduto.setText("");
            txtQuantidade.setText("");
            txtValor.setText("");

            JOptionPane.showMessageDialog(
                    null,
                    "Nota Fiscal cadastrada! ID: " + idNF
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Erro: " + e.getMessage()
            );

            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCadastrarNFActionPerformed

    private void txtDtEmissaoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDtEmissaoBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDtEmissaoBActionPerformed

    private void btnAtualizarNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarNFActionPerformed
        try {

            if (txtIdNF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o ID da NF!");
                return;
            }

            int idNF = Integer.parseInt(txtIdNF.getText());
            int idCliente = Integer.parseInt(txtIdClienteB.getText());
            int idProduto = Integer.parseInt(txtIdProdutoB.getText());
            int quantidade = Integer.parseInt(txtQuantidadeB.getText());
            double valor = Double.parseDouble(txtValorB.getText());

            NotaFiscalDAO dao = new NotaFiscalDAO();

            dao.atualizarNota(idNF, idCliente, idProduto, quantidade, valor);

            JOptionPane.showMessageDialog(null, "Nota atualizada com sucesso!");

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null, "Digite valores válidos!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAtualizarNFActionPerformed

    private int quantidade;

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    private void btnBuscarNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNFActionPerformed
        try {

            int idNF = Integer.parseInt(txtIdNF.getText());

            NotaFiscalDAO dao = new NotaFiscalDAO();

            ResultSet rs = dao.consultarNF(idNF);

            if (rs != null && rs.next()) {

                txtDtEmissaoB.setText(rs.getString("data_emissao"));
                txtIdClienteB.setText(rs.getString("id_cliente"));
                txtIdProdutoB.setText(rs.getString("id_produto"));
                txtQuantidadeB.setText(rs.getString("quantidade"));
                Double multiplicacao = Double.parseDouble(rs.getString("quantidade")) * Double.parseDouble(rs.getString("valor_unitario"));
                txtValorB.setText(multiplicacao.toString());
                
                
            } else {

                JOptionPane.showMessageDialog(null, "NF não encontrada!");
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null, "Digite um ID válido!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBuscarNFActionPerformed

    private void btnEmitirNFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirNFActionPerformed

    }//GEN-LAST:event_btnEmitirNFActionPerformed

    private void txtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeActionPerformed

    }//GEN-LAST:event_txtQuantidadeActionPerformed

    private void txtQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyPressed

    }//GEN-LAST:event_txtQuantidadeKeyPressed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed

    }//GEN-LAST:event_txtValorActionPerformed

    private void txtQuantidadeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQuantidadeMouseExited
        
    }//GEN-LAST:event_txtQuantidadeMouseExited

    private void txtQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyReleased
        ProdutoDAO produtoDao = new ProdutoDAO();
        String idProduto = txtIdProduto.getText();
        Produto produto = produtoDao.consultar(Integer.parseInt(idProduto));
        Double calculoValor = Integer.parseInt(txtQuantidade.getText()) * produto.getValor();

        txtValor.setText(calculoValor.toString());
    }//GEN-LAST:event_txtQuantidadeKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelClientes;
    private javax.swing.JPanel PainelHome;
    private javax.swing.JPanel PainelNotaFiscal;
    private javax.swing.JPanel PainelProduto;
    private javax.swing.JTabbedPane SistemaVendas;
    private javax.swing.JButton btnAtualizarCliente;
    private javax.swing.JButton btnAtualizarNF;
    private javax.swing.JButton btnAtualizarProduto;
    private javax.swing.JToggleButton btnBuscarNF;
    private javax.swing.JButton btnCadastrarCliente;
    private javax.swing.JButton btnCadastrarNF;
    private javax.swing.JButton btnCadastrarProduto;
    private javax.swing.JButton btnConsultarCliente;
    private javax.swing.JButton btnConsultarProduto;
    private javax.swing.JButton btnEmitirNF;
    private javax.swing.JButton btnExcluirCliente;
    private javax.swing.JButton btnExcluirProduto;
    private javax.swing.JPanel cadastrarnf;
    private javax.swing.JPanel cadastrarnf1;
    private javax.swing.JButton jButton10;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTable tabelaNotaFiscal;
    private javax.swing.JTable tabelaProdutos;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtCpfEditar;
    private javax.swing.JTextField txtDescricaoProduto;
    private javax.swing.JTextField txtDescricaoProdutoEditar;
    private javax.swing.JTextField txtDtEmissaoB;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailEditar;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtEnderecoEditar;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdClienteB;
    private javax.swing.JTextField txtIdNF;
    private javax.swing.JTextField txtIdProduto;
    private javax.swing.JTextField txtIdProdutoB;
    private javax.swing.JTextField txtIdProdutoEditar;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeEditar;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtNomeProdutoEditar;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtQuantidadeB;
    private javax.swing.JTextField txtQuantidadeProduto;
    private javax.swing.JTextField txtQuantidadeProdutoEditar;
    private javax.swing.JTextField txtTipoProduto;
    private javax.swing.JTextField txtTipoProdutoEditar;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtValorB;
    private javax.swing.JTextField txtValorProduto;
    private javax.swing.JTextField txtValorProdutoEditar;
    // End of variables declaration//GEN-END:variables
}
