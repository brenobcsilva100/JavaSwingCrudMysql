/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escoladereforco;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
class UsurioDAO {

    private Connection con = ConexaoFactory.getConnection(); 
    
   public void cadastrar(Usuario usu) {
        String sql = "insert into usuario (nome,login,senha) values(?,?,?)";
        
        try (PreparedStatement preparador = con.prepareStatement(sql)){
            preparador.setString(1, usu.getNome());
            preparador.setString(2, usu.getLogin());
            preparador.setString(3, usu.getSenha());
            
            preparador.execute();
            preparador.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsurioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void alterar(Usuario usu) {
         String sql = "update usuario set nome=?, login=?, senha=? where id=?";
        
        try (PreparedStatement preparador = con.prepareStatement(sql)){
            preparador.setString(1, usu.getNome());
            preparador.setString(2, usu.getLogin());
            preparador.setString(3, usu.getSenha());
            preparador.setInt(4, usu.getId());
            
            preparador.execute();
            preparador.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsurioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void excluir(Usuario usu) {
     String sql = "delete from usuario where id=?";
        
        try (PreparedStatement preparador = con.prepareStatement(sql)){
         
            preparador.setInt(1, usu.getId());
            
            preparador.execute();
            preparador.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsurioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salvar(Usuario usuario){
        if(usuario.getId()!=null){
            alterar(usuario);
        }else{
            cadastrar(usuario);
        }
    }
    
    public Usuario buscarPorId(Integer id){
        String sql = "select * from usuario where id=?";
        try (PreparedStatement preparador = con.prepareStatement(sql)){
            preparador.setInt(1, id);
            ResultSet resultado = preparador.executeQuery();
            if(resultado.next()){
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getInt("id"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                
                return usuario;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsurioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
     public ArrayList<Usuario> buscarTodos(){
        String sql = "select * from usuario";
        var lista = new ArrayList<Usuario>();
        try (PreparedStatement preparador = con.prepareStatement(sql)){
            
            ResultSet resultado = preparador.executeQuery();
            while(resultado.next()){
                Usuario usuario = new Usuario();
                usuario.setId(resultado.getInt("id"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                
                lista.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsurioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
     
     public Usuario autenticar(Usuario usuconsulta){
         String sql = "select * from usuario where login=? and senha=?";
        try(PreparedStatement preparador = con.prepareStatement(sql)){
            
        preparador.setString(1, usuconsulta.getLogin());
        preparador.setString(2, usuconsulta.getSenha());
        ResultSet resultado = preparador.executeQuery();
        
        if(resultado.next()){
        Usuario usuario = new Usuario();
        usuario.setId(resultado.getInt("id"));
        usuario.setNome(resultado.getString("nome"));
        usuario.setLogin(resultado.getString("login"));
        usuario.setSenha(resultado.getString("senha"));
        return usuario;
        }else{
            return null;
        }
        } catch (SQLException ex) {
            Logger.getLogger(UsurioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     }  
}
