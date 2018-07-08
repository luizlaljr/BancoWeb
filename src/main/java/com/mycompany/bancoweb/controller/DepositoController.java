/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancoweb.controller;

import com.mycompany.bancoweb.dao.ClienteDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luizlaljr
 */
public class DepositoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        float valorDepositar = Float.parseFloat(request.getParameter("valor"));
        ClienteDao cDao = new ClienteDao();
        int sessaoID = (Integer) request.getSession(false).getAttribute("contaLogada");
        cDao.depositar(sessaoID, valorDepositar);
        RequestDispatcher dispatcher = request.getRequestDispatcher("deposito_realizado.jsp");
        request.setAttribute("conta", sessaoID);
        request.setAttribute("valor", valorDepositar);
        dispatcher.forward(request, response);
    }

}
