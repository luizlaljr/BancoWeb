/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancoweb.controller;

import com.mycompany.bancoweb.dao.ClienteDao;
import com.mycompany.bancoweb.model.Cliente;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luizlaljr
 */
@WebServlet(name = "LoginController", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet { 
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        response.sendRedirect("index.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = (String)request.getParameter("login");
        String senha = (String)request.getParameter("senha");
        ClienteDao cdao;
        Cliente cliente;
        cdao = new ClienteDao();
        cliente = cdao.validar(login,senha);               
        
        if(cliente!=null){
            HttpSession session = request.getSession();
            session.setAttribute("contaLogada", cliente.getConta());
            session.setAttribute("loginStatus", Cliente.LOGADO);
            RequestDispatcher dispatcher = request.getRequestDispatcher("logado.jsp");
            request.setAttribute("cliente", cliente.getNome());
            request.setAttribute("conta", cliente.getConta());
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect("erro_login.jsp");
        }
    }

}
