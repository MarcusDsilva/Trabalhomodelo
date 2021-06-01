package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
  * @author Computador
 */
public class UsuarioDao {
    Connection con;
    
    public UsuarioDao() throws SQLException{
    con = ConnectionFactory.getConnection();
    }
    public boolean checkLogin(String email, String senha){
    PreparedStatement stmt = null;
    ResultSet rs = null; 
    boolean check = false;
        try {
            stmt = con.prepareStatement("SELECT * FROM tbusuario" 
                    + " where email = ? AND senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            if(rs.next()){
            check = true;
            }          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro: " +e.getMessage());
        }
    return check;
    }
    public void create(Usuario u){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbusuario (nome,"
                    + "email,senha,tipo) VALUE (?,?,?,?)");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getTipo());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Usuario"+u.getNome()
                   +"Salvo com sucesso");  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:" +e.getMessage());
        }finally{
        ConnectionFactory.closeConnection(con, stmt);
        }  
    }
    public void update(Usuario u){
     PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbusuario SET nome = ?,"
                    + "email = ?, senha = ?, tipo = ? WHERE id = ?");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getTipo());
            stmt.setInt   (5, u.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario" +u.getNome()
                   +" Modificado com sucesso ");   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:" +e.getMessage());
        }finally{
        ConnectionFactory.closeConnection(con, stmt);
        } 
    }
   public void delete(Usuario u){
   PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbusuario WHERE id = ?");   
            
            stmt.setInt   (1, u.getId());
           
            if (JOptionPane.showConfirmDialog(null,"Exclusão", "Tem certeza que"
                    + " deseja excluir o Usuario"+u.getNome(),
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            
                {JOptionPane.showMessageDialog(null,"Usuario"+u.getNome()
                   +" Excluido com sucesso ");
               stmt.executeUpdate();          }  
            }else{JOptionPane.showMessageDialog(null,"A exclusao do Usuario"+u.getNome()
                   +" cancelado com sucesso ");
                        }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:" +e.getMessage());
        }finally{
        ConnectionFactory.closeConnection(con, stmt);
        }
   } 
   public ArrayList<Usuario> read (){
   PreparedStatement stmt = null;
   ResultSet rs = null;
   List<Usuario> usuarios = new ArrayList<Usuario>();
       try {
           stmt = con.prepareStatement("SELECT * FROM tbusuario"); 
           rs = stmt.executeQuery();
           while(rs.next()){
           Usuario usuario = new Usuario();
           usuario.setId(rs.getInt("id"));
           usuario.setNome(rs.getString("nome"));
           usuario.setEmail(rs.getString("email"));
           usuario.setSenha(rs.getString("senha"));
           usuario.setTipo(rs.getString("tipo"));
           usuarios.add(usuario);  
           }
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage());
       }finally{
   ConnectionFactory.closeConnection(con, stmt, rs);
   }
   return (ArrayList<Usuario>) usuarios; 
   }
    public ArrayList<Usuario> readPesq(String nome){
   PreparedStatement stmt = null;
   ResultSet rs = null;
   List<Usuario> usuarios = new ArrayList<Usuario>();
       try {
           stmt = con.prepareStatement("SELECT * FROM tbusuario WHERE nome LIKE ?");
            stmt.setString(1, "%"+nome+"%");
           rs = stmt.executeQuery();
           while(rs.next()){
           Usuario usuario = new Usuario();
           usuario.setId(rs.getInt("id"));
           usuario.setNome(rs.getString("nome"));
           usuario.setEmail(rs.getString("email"));
           usuario.setSenha(rs.getString("senha"));
           usuario.setTipo(rs.getString("tipo"));
           usuarios.add(usuario);   
           }
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage());
       }finally{
   ConnectionFactory.closeConnection(con, stmt, rs);
   }
   return (ArrayList<Usuario>) usuarios;  
   }
    public void delet(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
