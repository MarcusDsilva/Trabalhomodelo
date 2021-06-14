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


public class FabricanteDao {
  Connection con;
    
    public FabricanteDao() throws SQLException{
    con = ConnectionFactory.getConnection();
    }
    
 public ArrayList<Fabricante> read(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Fabricante> fabricantes = new ArrayList<Fabricante>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbfabricante ORDER BY marca ASC");
            rs = stmt.executeQuery();
            while(rs.next()){
                Fabricante f = new Fabricante();
                f.setId(rs.getInt("id"));
                f.setMarca(rs.getString("marca"));
                f.setTelefone(rs.getString("telefone"));
                f.setEmail(rs.getString("email"));
                f.setSite(rs.getString("site"));              
                fabricantes.add(f);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Fabricante>) fabricantes;
    }
    
     public ArrayList<Fabricante> readPesq(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Fabricante> fabricantes = new ArrayList<Fabricante>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbfabricante WHERE marca LIKE ?");
            rs = stmt.executeQuery();
            while(rs.next()){
                Fabricante f = new Fabricante();
                f.setId(rs.getInt("id"));
                f.setMarca(rs.getString("marca"));
                f.setTelefone(rs.getString("telefone"));
                f.setEmail(rs.getString("email"));
                f.setSite(rs.getString("site"));              
                fabricantes.add(f);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Fabricante>) fabricantes;
    }
    
    
   // SALVA O USUARIO NO BANCO DE DADOS   ---- C
    public void create(Fabricante f){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbfabricante (marca,"
                    + "telefone,email,site) VALUE (?,?,?,?)");
            stmt.setString(1, f.getMarca());
            stmt.setString(2, f.getTelefone());
            stmt.setString(3, f.getEmail());
            stmt.setString(4, f.getSite());
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "O "+f.getMarca()
                    +" Salvo com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    //ALTERAR O USUARIO NO BANCO DE DADOS   -- U 
    public void update(Fabricante f){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbfabricante SET marca = ?,"
                    + "marca = ?, telefone = ? ,email = ?, site = ? WHERE id = ?");
           stmt.setString(1, f.getMarca());
            stmt.setString(2, f.getTelefone());
            stmt.setString(3, f.getEmail());
            stmt.setString(4, f.getSite());
            stmt.setInt(5, f.getId());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario "+f.getMarca()
                    +" Modificado com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    //excluir do banco de dados   --- D
    public void delete(Fabricante f){
            PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbfabricante WHERE id = ?");
           
            stmt.setInt   (1, f.getId());
            
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que"
                    + " deseja excluir este fabricante","Exclusão",
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Fabricante excluído com Sucesso!!");
                stmt.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "A exclusão do Fabricante Cancelado(a)com Sucesso!!");
            }
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Iterable<Fabricante> readPesq(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
    


