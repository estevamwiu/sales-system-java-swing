package dao;

import util.Conexao;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO {

    // CADASTRAR
    public void cadastrar(Produto produto) {

        String sql =
        "INSERT INTO produtos(nome, descricao, tipo, valor, quantidade) VALUES (?, ?, ?, ?, ?)";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getDescricao());
            pst.setString(3, produto.getTipo());
            pst.setDouble(4, produto.getValor());
            pst.setInt(5, produto.getQuantidade());

            pst.execute();

            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("Erro cadastrar produto: " + e);
        }
    }

    // LISTAR
    public ArrayList<Produto> listar() {

        ArrayList<Produto> lista = new ArrayList<>();

        String sql = "SELECT * FROM produtos";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setIdProduto(
                        rs.getInt("id_produto"));

                produto.setNome(
                        rs.getString("nome"));

                produto.setDescricao(
                        rs.getString("descricao"));

                produto.setTipo(
                        rs.getString("tipo"));

                produto.setValor(
                        rs.getDouble("valor"));

                produto.setQuantidade(
                        rs.getInt("quantidade"));

                lista.add(produto);
            }

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("Erro listar produtos: " + e);
        }

        return lista;
    }

    // CONSULTAR
    public Produto consultar(int id) {

        Produto produto = new Produto();

        String sql =
        "SELECT * FROM produtos WHERE id_produto = ?";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                produto.setIdProduto(
                        rs.getInt("id_produto"));

                produto.setNome(
                        rs.getString("nome"));

                produto.setDescricao(
                        rs.getString("descricao"));

                produto.setTipo(
                        rs.getString("tipo"));

                produto.setValor(
                        rs.getDouble("valor"));

                produto.setQuantidade(
                        rs.getInt("quantidade"));
            }

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("Erro consultar produto: " + e);
        }

        return produto;
    }

    // ATUALIZAR
    public void atualizar(Produto produto) {

        String sql =
        "UPDATE produtos SET nome=?, descricao=?, tipo=?, valor=?, quantidade=? WHERE id_produto=?";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getDescricao());
            pst.setString(3, produto.getTipo());
            pst.setDouble(4, produto.getValor());
            pst.setInt(5, produto.getQuantidade());
            pst.setInt(6, produto.getIdProduto());

            pst.executeUpdate();

            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("Erro atualizar produto: " + e);
        }
    }

    // EXCLUIR
    public void excluir(int id) {

        String sql =
        "DELETE FROM produtos WHERE id_produto=?";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setInt(1, id);

            pst.execute();

            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("Erro excluir produto: " + e);
        }
    }
}