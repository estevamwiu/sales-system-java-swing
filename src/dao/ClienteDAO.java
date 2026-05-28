package dao;

import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.Conexao;

public class ClienteDAO {

    public void cadastrar(Cliente cliente) {

        String sql =
        "INSERT INTO clientes(nome, cpf, endereco, email) VALUES (?, ?, ?, ?)";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCpf());
            pst.setString(3, cliente.getEndereco());
            pst.setString(4, cliente.getEmail());

            pst.execute();

            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("Erro cadastrar cliente: " + e);
        }
    }

    public ArrayList<Cliente> listar() {

        ArrayList<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM clientes";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setIdCliente(
                        rs.getInt("id_cliente"));

                cliente.setNome(
                        rs.getString("nome"));

                cliente.setCpf(
                        rs.getString("cpf"));

                cliente.setEndereco(
                        rs.getString("endereco"));

                cliente.setEmail(
                        rs.getString("email"));

                lista.add(cliente);
            }

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("Erro listar clientes: " + e);
        }

        return lista;
    }

    public Cliente consultar(String cpf) {

        Cliente cliente = new Cliente();

        String sql =
        "SELECT * FROM clientes WHERE cpf = ?";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, cpf);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                cliente.setIdCliente(
                        rs.getInt("id_cliente"));

                cliente.setNome(
                        rs.getString("nome"));

                cliente.setCpf(
                        rs.getString("cpf"));

                cliente.setEndereco(
                        rs.getString("endereco"));

                cliente.setEmail(
                        rs.getString("email"));
            }

            rs.close();
            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("Erro consultar cliente: " + e);
        }

        return cliente;
    }

    public void atualizar(Cliente cliente) {

        String sql =
        "UPDATE clientes SET nome=?, endereco=?, email=? WHERE cpf=?";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEndereco());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getCpf());

            pst.executeUpdate();

            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("Erro atualizar cliente: " + e);
        }
    }

    public void excluir(String cpf) {

        String sql =
        "DELETE FROM clientes WHERE cpf=?";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement pst =
                    conn.prepareStatement(sql);

            pst.setString(1, cpf);

            pst.execute();

            pst.close();
            conn.close();

        } catch (Exception e) {

            System.out.println("Erro excluir cliente: " + e);
        }
    }
}