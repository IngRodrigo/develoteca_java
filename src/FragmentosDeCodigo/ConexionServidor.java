package FragmentosDeCodigo;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author rodrigo_dev
 * 
 * Fragmeto de codigo para conectarse a un servidor por sftp y ejecutar comandos por consola en el mismo
 */
public class ConexionServidor extends Conexion{
    
    public void conectar(String id_reporte) throws JSchException, IOException{
   
        // getIdReporte();
        
        JSch jsch = new JSch();
        Session session = jsch.getSession("webdesa", "webapp2", 22);
        session.setPassword("WWWd3v3l");
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();

        ChannelExec channel;
        channel = (ChannelExec) session.openChannel("exec");
        BufferedReader in = new BufferedReader(new InputStreamReader(channel.getInputStream()));
        //channel.setCommand("php chmod ('../archivos/', 0755)");
        //channel.setCommand("php /var/www/html/reportes/ws/queryreport.php enviarCorreo "+id_reporte+" DESCSV");
        channel.setCommand("php /var/www/html/reportes/ws/queryreport.php enviarCorreo "+id_reporte+" DESCSV");
        //channel.setCommand("java -version");
        channel.connect();

        String msg = null;
        while ((msg = in.readLine()) != null) {
            System.out.println(msg);
        }
    
        channel.disconnect();
        session.disconnect();
        
    
    }
     
     private String getIdReporte(){
         String resultado="";
         ArrayList<String>idReporte=new ArrayList<>();
        try {
             ResultSet result=listarRegistros();
             while (result.next()) {                
                  idReporte.add(result.getString("id_reporte"));
            }
             for (int i = 0; i < idReporte.size(); i++) {
                 System.out.println(idReporte.get(i));
                
            }
         } catch (Exception e) {
            }
         return resultado;
     }
  
}
