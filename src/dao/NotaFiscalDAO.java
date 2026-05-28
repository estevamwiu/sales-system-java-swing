package dao;

import util.Conexao;
import model.ItemNF;
import model.NotaFiscal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotaFiscalDAO {

    private Connection conn;

    // CONSTRUTOR
    public NotaFiscalDAO() {

        try {
            this.conn = Conexao.conectar();
        } catch (Exception e) {
            System.out.println("Erro conexão: " + e);
        }
    }

    // ✅ 1. CADASTRAR NF
    public int cadastrarNF(NotaFiscal nf) {

        int idGerado = 0;

        try {

            String sql =
            "INSERT INTO nota_fiscal (data_emissao, id_cliente) VALUES (NOW(), ?)";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, nf.getIdCliente());

            pst.executeUpdate();

            // pegar ID gerado
            String sql2 = "SELECT LAST_INSERT_ID()";
            PreparedStatement pst2 = conn.prepareStatement(sql2);
            ResultSet rs = pst2.executeQuery();

            if (rs.next()) {
                idGerado = rs.getInt(1);
            }

        } catch (Exception e) {

            System.out.println("Erro cadastrar NF: " + e);
        }

        return idGerado;
    }

    // ✅ 2. INSERIR ITEM DA NOTA
    public void inserirItem(ItemNF item) {

        try {

            String sql =
            "INSERT INTO itens_nota (id_nf, id_produto, quantidade, valor_unitario) " +
            "VALUES (?, ?, ?, ?)";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, item.getIdNF());
            pst.setInt(2, item.getIdProduto());
            pst.setInt(3, item.getQuantidade());
            pst.setDouble(4, item.getValorUnitario());

            pst.execute();

        } catch (Exception e) {

            System.out.println("Erro inserir item: " + e);
        }
    }

    // ✅ 3. CONSULTAR NF
    public ResultSet consultarNF(int idNF) {

        try {

            String sql =
            "SELECT nf.data_emissao, nf.id_cliente, " +
            "i.id_produto, i.quantidade, i.valor_unitario " +
            "FROM nota_fiscal nf " +
            "INNER JOIN itens_nota i ON nf.id_nf = i.id_nf " +
            "WHERE nf.id_nf = ?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, idNF);

            return pst.executeQuery();

        } catch (Exception e) {

            System.out.println("Erro consultar NF: " + e);
            return null;
        }
    }

    // ✅ 4. ATUALIZAR NF
    public void atualizarNota(int idNF, int idCliente, int idProduto, int quantidade, double valor) {

        try {

            // atualizar cliente
            String sqlNF = "UPDATE nota_fiscal SET id_cliente=? WHERE id_nf=?";
            PreparedStatement pstNF = conn.prepareStatement(sqlNF);

            pstNF.setInt(1, idCliente);
            pstNF.setInt(2, idNF);
            pstNF.executeUpdate();

            // atualizar item
            String sqlItem =
            "UPDATE itens_nota SET id_produto=?, quantidade=?, valor_unitario=? WHERE id_nf=?";

            PreparedStatement pstItem = conn.prepareStatement(sqlItem);

            pstItem.setInt(1, idProduto);
            pstItem.setInt(2, quantidade);
            pstItem.setDouble(3, valor);
            pstItem.setInt(4, idNF);

            pstItem.executeUpdate();

        } catch (Exception e) {

            System.out.println("Erro atualizar NF: " + e);
        }
    }
    
    public ResultSet listarNotas() {

    try {

        String sql =
        "SELECT nf.data_emissao, nf.id_nf, " +
        "c.nome AS nome_cliente, " +
        "p.id_produto, p.nome AS nome_produto, p.descricao, " +
        "i.quantidade, i.valor_unitario " +
        "FROM nota_fiscal nf " +
        "INNER JOIN clientes c ON nf.id_cliente = c.id_cliente " +
        "INNER JOIN itens_nota i ON nf.id_nf = i.id_nf " +
        "INNER JOIN produtos p ON i.id_produto = p.id_produto";

        PreparedStatement pst = conn.prepareStatement(sql);

        return pst.executeQuery();

    } catch (Exception e) {

        System.out.println("Erro listar notas: " + e);
        return null;
    }
}
}
