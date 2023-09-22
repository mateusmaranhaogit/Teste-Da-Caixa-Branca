import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TesteCaixaBranca {
    public Connection conectarBD(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/teset7user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        }catch (Exception e) { }
        return conn;
    public String nome="";
    public boolean result = false;
    public boolean VerificarUsuario(String login, String senha) {
        String sql = " ";
        Connection conn = conectarBD();
        // INSTRUÇÃO SQL
        sql += "select nome from usuarios ";
        sql += "where login = " + "'" + senha "';";
        try{
            Statment st = conn.createStatment();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                result = true;
                nome = rs.getString("nome");}
            }catch (Exception e) {  }
            return result; }
        }//fim da classe
    }
    

