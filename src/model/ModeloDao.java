/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ModeloDao {
   Connection con;
    
    public ModeloDao() throws SQLException{
    con = ConnectionFactory.getConnection();
    }
    
 public ArrayList<Modelo> read(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Modelo> modelo = new ArrayList<Modelo>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbmodelo ORDER BY marca ASC");
            rs = stmt.executeQuery();
            while(rs.next()){
                Modelo m = new Modelo();
                m.setId(rs.getInt("id"));
                m.setModelo(rs.getString("modelo"));
                m.setMarca(rs.getString("marca"));
                m.setAno(rs.getInt("ano"));           
                modelo.add(m);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Modelo>) modelo;
    }
    
     public ArrayList<Modelo> readPesq(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Modelo> modelo = new ArrayList<Modelo>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbmodelo WHERE marca LIKE ?");
            rs = stmt.executeQuery();
            while(rs.next()){
                Modelo m = new Modelo();
               m.setId(rs.getInt("id"));
                m.setModelo(rs.getString("modelo"));
                m.setMarca(rs.getString("marca"));
                m.setAno(rs.getInt("ano"));              
                modelo.add(m);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Modelo>) modelo;
    }
    
    
   // SALVA O USUARIO NO BANCO DE DADOS   ---- C
    public void create(Modelo m){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbmodelo (modelo,"
                    + "marca,ano) VALUE (?,?,?)");
            stmt.setString(1, m.getModelo());
            stmt.setString(2, m.getMarca());
            stmt.setInt(3, m.getAno());
            
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "O "+m.getMarca()
                    +" Salvo com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //ALTERAR O USUARIO NO BANCO DE DADOS   -- U 
    public void update(Modelo m){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbmodelo SET modelo = ?,"
                    + "marca = ?, ano = ? WHERE id = ?");
           stmt.setString(1, m.getModelo());
            stmt.setString(2, m.getMarca());
            stmt.setInt(3, m.getAno());
            stmt.setInt(4, m.getId());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario "+m.getMarca()
                    +" Modificado com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    //excluir do banco de dados   --- D
    public void delete(Modelo m){
            PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbmodelo WHERE id = ?");
           
            stmt.setInt   (1, m.getId());
            
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que"
                    + " deseja excluir este modelo ","Exclusão",
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "modelo excluído com Sucesso!!");
                stmt.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "A exclusão do modelo Cancelado com Sucesso!!");
            }
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Iterable<Modelo> readPesq(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
   
}  

