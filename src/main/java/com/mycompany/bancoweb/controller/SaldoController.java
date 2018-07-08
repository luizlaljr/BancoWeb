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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luizlaljr
 */
@WebServlet(name = "SaldoController", urlPatterns = {"/Saldo"})
public class SaldoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ClienteDao cDao = new ClienteDao();
        int sessaoID = (Integer) request.getSession(false).getAttribute("contaLogada");
        float saldo = cDao.saldo(sessaoID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("logado_saldo.jsp");
        request.setAttribute("conta", sessaoID);
        request.setAttribute("valor", saldo);
        dispatcher.forward(request, response);
    }
}
