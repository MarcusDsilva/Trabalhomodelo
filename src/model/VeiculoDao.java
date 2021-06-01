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

/**
 *
 * @author Computador
 */
public class VeiculoDao {
  Connection con;
    
    public VeiculoDao() throws SQLException{
    con = ConnectionFactory.getConnection();
    }
    public void create(Veiculo u){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbveiculo (marca,modelo, ano,cor,placa"
                    + "motor,km,valorfipe) VALUE (?,?,?,?,?,?,?,?)");
            stmt.setString(1, u.getMarca());
            stmt.setString(2, u.getModelo());
            stmt.setInt(3, u.getAno());
            stmt.setString(4, u.getCor());
            stmt.setString(5, u.getPlaca());
            stmt.setString(6, u.getMotor());
            stmt.setString(7, u.getKm());
            stmt.setDouble(8, u.getValorFipe()); 
            stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Veiculo"+u.getMarca()
                   +"Salvo com sucesso");  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:" +e.getMessage());
        }finally{
        ConnectionFactory.closeConnection(con, stmt);
        }  
    }
    
    
    public void update(Veiculo u){
     PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbveiculo SET marca = ?,"
                    + "modelo = ?, ano = ?, cor = ?, placa = ?, motor = ?, km = ?, valorfipe = ? WHERE id = ?");
             stmt.setString(1, u.getMarca());
            stmt.setString(2, u.getModelo());
            stmt.setInt   (3, u.getAno());
            stmt.setString(4, u.getCor());
            stmt.setString(5, u.getPlaca());
            stmt.setString(6, u.getMotor());
            stmt.setString(7, u.getKm());
            stmt.setDouble(8, u.getValorFipe());
            stmt.setInt   (9, u.getId());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Veiculo" +u.getMarca()
                   +" Modificado com sucesso ");   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:" +e.getMessage());
        }finally{
        ConnectionFactory.closeConnection(con, stmt);
        } 
    }
    
    
   public void delete(Veiculo u){
   PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbveiculo WHERE id = ?");   
            
            stmt.setInt   (1, u.getId());
           
            if (JOptionPane.showConfirmDialog(null,"Exclusão", "Tem certeza que"
                    + " deseja excluir o Veiculo"+u.getMarca(),
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            
                {JOptionPane.showMessageDialog(null,"Veiculo"+u.getMarca()
                   +" Excluido com sucesso ");
               stmt.executeUpdate();          }  
            }else{JOptionPane.showMessageDialog(null,"A exclusao do Veiculo"+u.getMarca()
                   +" cancelado com sucesso ");
                        }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:" +e.getMessage());
        }finally{
        ConnectionFactory.closeConnection(con, stmt);
        }
   } 
   public ArrayList<Veiculo> read (){
   PreparedStatement stmt = null;
   ResultSet rs = null;
   List<Veiculo> veiculo = new ArrayList<Veiculo>();
       try {
           stmt = con.prepareStatement("SELECT * FROM tbveiculo"); 
           rs = stmt.executeQuery();
           while(rs.next()){
           Veiculo veiculos = new Veiculo();
           veiculos.setId(rs.getInt("id"));
           veiculos.setMarca(rs.getString("marca"));
           veiculos.setModelo(rs.getString("modelo"));
           veiculos.setAno(rs.getInt("ano"));
           veiculos.setCor(rs.getString("cor"));
           veiculos.setPlaca(rs.getString("placa"));
           veiculos.setMotor(rs.getString("motor"));
           veiculos.setKm(rs.getString("km"));
           veiculos.setValorFipe(rs.getDouble("valorFipe"));   
           veiculos.add(veiculos);  
           }
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage());
       }finally{
   ConnectionFactory.closeConnection(con, stmt, rs);
   }
   return (ArrayList<Veiculo>) veiculo; 
   }
   
   
    public ArrayList<Veiculo> readPesq(String nome){
   PreparedStatement stmt = null;
   ResultSet rs = null;
   List<Veiculo> veiculo = new ArrayList<Veiculo>();
       try {
           stmt = con.prepareStatement("SELECT * FROM tbveiculo WHERE marca LIKE ?");
       String marca = null;
            stmt.setString(1, "%"+marca+"%");
           rs = stmt.executeQuery();
           while(rs.next()){  
           Veiculo veiculos = new Veiculo();
           veiculos.setId(rs.getInt("id"));
           veiculos.setMarca(rs.getString("marca"));
           veiculos.setModelo(rs.getString("modelo"));
           veiculos.setAno(rs.getInt("ano"));
           veiculos.setCor(rs.getString("cor"));
           veiculos.setPlaca(rs.getString("placa"));
           veiculos.setMotor(rs.getString("motor"));
           veiculos.setKm(rs.getString("km"));
           veiculos.setValorFipe(rs.getDouble("valor"));
           veiculos.add(veiculos);   
           }
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage());
       }finally{
   ConnectionFactory.closeConnection(con, stmt, rs);
   }
   return (ArrayList<Veiculo>) veiculo;  
   }
} 
    


