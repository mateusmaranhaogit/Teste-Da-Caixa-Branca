package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * A classe User é responsável por fornecer métodos para autenticação de usuários
 * em um banco de dados MySQL.
 */
public class User {

    /**
     * Método para estabelecer uma conexão com o banco de dados MySQL.
     *
     * @return Uma conexão ativa com o banco de dados, ou null em caso de falha.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver JDBC para MySQL
            Class.forName("com.mysql.Driver.Manager").newInstance();

            // Define a URL de conexão com o banco de dados, o usuário e a senha
            String url = "jdbc:mysql://127.0.0.1/teste?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Em caso de exceção, retorna null
        }
        return conn;
    }

    // Variáveis de classe
    public String nome = "";
    public boolean result = false;

    /**
     * Verifica se um usuário com as credenciais fornecidas existe no banco de dados.
     *
     * @param login O nome de usuário.
     * @param senha A senha do usuário.
     * @return true se o usuário existe e a senha corresponde, false caso contrário.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD();

        // INSTRUÇÃO SQL para buscar um usuário com as credenciais fornecidas
        sql += "SELECT nome FROM usuarios ";
        sql += "WHERE login = '" + login + "'";
        sql += " AND senha = '" + senha + "';";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Se um resultado é retornado, o usuário existe e as credenciais são válidas
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            // Em caso de exceção, result permanece como false
        }
        return result;
    }
}
