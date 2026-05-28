package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static final String URL =
            "jdbc:mysql://localhost:3306/sistema_vendas";

    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection conectar() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD
                    );

            System.out.println("Conectado!");

            return conn;

        } catch (Exception e) {

            System.out.println("Erro conexão:");
            e.printStackTrace();

            return null;
        }
    }
}