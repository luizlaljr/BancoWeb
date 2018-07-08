package com.mycompany.bancoweb.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author luizlaljr
 */
public class ConnectionFactory {

    final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://localhost:3306/";
    final private String usuario = "root";
    final private String senha = "ctfu06";
    private Connection conexao;

    public ConnectionFactory() {

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            String sql = "CREATE DATABASE IF NOT EXISTS `dbdw` /*!40100 DEFAULT CHARACTER SET utf8 */";
            Statement stmt = conexao.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (ClassNotFoundException Driver) {
            System.out.println("Driver não localizado: " + Driver);
            
        } catch (SQLException Fonte) {
            System.out.println("Erro na conexão com a fonte de dados: " + Fonte);
            
        }
    }

    public Connection getConnection() {
        return this.conexao;
    }

    public void closeConnection() {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
