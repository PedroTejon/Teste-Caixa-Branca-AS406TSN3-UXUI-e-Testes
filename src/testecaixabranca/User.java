package testecaixabranca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Uma classe representando um usuário.
 *
 * @author Pedro Tejon
 * @version 1.0
 */
public class User {

    /**
     * O nome do usuário. Seu valor começa vázio e será definido após a execução do método {@link #verificarUsuario(String, String)}.
     */
    public String nome = "";

    /**
     * O valor que determina se a verificação do usuário foi bem definida, começa como falso por padrão e será definido após a execução do método {@link #verificarUsuario(String, String)}.
    */
    public boolean result = false;

    /**
     * Retorna uma conexão com o banco de dados.
     * 
     * @return    uma Connection
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
        }
        return conn;
    }

    /**
     * Retorna um valor booleano que determina se a verificação de usuário foi bem sucedida.
     *
     * @param     login o login do usuário.
     * @param     senha a senha do usuário.
     * @return    um valor booleano
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD();
        sql += "select nome from usuarios ";
        sql += "where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
        }
        return result;
    }
}
