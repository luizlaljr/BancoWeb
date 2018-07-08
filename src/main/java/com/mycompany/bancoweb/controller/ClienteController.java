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

/**
 *
 * @author luizlaljr
 */
@WebServlet(name = "ClienteController", urlPatterns = {"/Cadastro"})
public class ClienteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteDao cdao = new ClienteDao();
        Cliente cliente = new Cliente();
        cliente.setNome(request.getParameter("nome"));
        cliente.setLogin(request.getParameter("login"));
        cliente.setCpf(request.getParameter("cpf"));
        cliente.setSenha(request.getParameter("senha"));

        if (cdao.inserir(cliente)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("cliente.jsp");
            Cliente c = cdao.buscar(request.getParameter("cpf"));
            request.setAttribute("cliente", c);
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect("erro_cadastro.jsp");
        }
        
    }

}
