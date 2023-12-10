
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server {
    String db="farmacia";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String passw="78531015aA@";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;
    
    public Server(){
        
    }
    
    public Connection connect(){
        try{
            Class.forName(driver);
            cx=DriverManager.getConnection(url+db, user, passw);
            System.out.println("Bienvenido a "+db);
        }catch(ClassNotFoundException |SQLException ex) {
            System.out.println("No se pudo establecer la conexion a "+db);
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return cx;
    }
    
    public void desconnect(){
        try{
            cx.close();
        }catch(SQLException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

}
