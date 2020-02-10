package trabajo;



import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class ConexioDB {
   static Connection conn = null;
   public static Connection getConnection() {
      if (conn != null) return conn;
      String database = "animes";
      String Username = "root";
      String password = "Cebiche123";
      return getConnection(database, Username, password);
   }
   private static Connection getConnection(String databaseName, String UserName, String password) {
      try {
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?user=" + UserName + "&password=" + password);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return conn;
   }
    public static ResultSet getTabla(String Consulta){
        Connection cn=getConnection();
        Statement st;
        ResultSet datos=null;
        try{
            st=(Statement) cn.createStatement();
            datos=st.executeQuery(Consulta);            
        }
        catch(Exception e){ System.out.print(e.toString());}
        return datos;
    }  
}