/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escoladereforco;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class TestUsuarioDAO {
    
    public static void main(String[] args) {
        testAutenticar();
    }
    
     public static void testAlterar(){
        Usuario usu = new Usuario();
        usu.setId(1);
        usu.setNome("Jao alterado");
        usu.setLogin("jaoLogin alterado");
        usu.setSenha("jsenha alterado");
        
        UsurioDAO usuDao = new UsurioDAO();
        usuDao.alterar(usu);
        
        System.out.println("Alterado com sucesso!");
    }
    
    public static void testCadastrar(){
        Usuario usu = new Usuario();
        usu.setNome("Jao");
        usu.setLogin("jaoLogin");
        usu.setSenha("jsenha");
        
        UsurioDAO usuDao = new UsurioDAO();
        usuDao.cadastrar(usu);
        
        System.out.println("Cadastrado com sucesso!");
    }
    
     public static void testExcluir(){
        Usuario usu = new Usuario();
        usu.setId(2);
        
        UsurioDAO usuDao = new UsurioDAO();
        usuDao.excluir(usu);
        
        System.out.println("Excluido com sucesso!");
    }
     
     public static void testSalvar(){
         Usuario usuario = new Usuario();
         usuario.setId(1);
         usuario.setNome("Maria de souza alterado");
         usuario.setLogin("MariaLogin alterado");
         usuario.setSenha("MariaSenha alterado");
         
         UsurioDAO usudao = new UsurioDAO();
         usudao.salvar(usuario);
         
         System.out.println("Salvo com sucesso!");
     }

    private static void testBuscarPorId() {
        UsurioDAO usurioDAO = new UsurioDAO();
        Usuario usuario = usurioDAO.buscarPorId(3);
        System.out.println(usuario);
    }
    
      private static void testBuscarTodos() {
        UsurioDAO usurioDAO = new UsurioDAO();
        ArrayList<Usuario> buscarTodos = usurioDAO.buscarTodos();
        for(Usuario u: buscarTodos){
            System.out.println(u);
        }
    }

    private static void testAutenticar() {
        UsurioDAO usudao = new UsurioDAO();
        Usuario usu = new Usuario();
        usu.setLogin("MariaLogin alterado");
        usu.setSenha("MariaSenha alterado");
        Usuario usuRetorno = usudao.autenticar(usu);
        System.out.println(usuRetorno);
    }
    
}
