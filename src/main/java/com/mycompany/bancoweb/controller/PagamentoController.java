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
@WebServlet(name = "PagamentoController", urlPatterns = {"/Pagamento"})
public class PagamentoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ClienteDao cDao = new ClienteDao();
        int sessaoID = (Integer) request.getSession(false).getAttribute("contaLogada");
        float saldo = cDao.saldo(sessaoID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("logado_pagamento.jsp");
        request.setAttribute("conta", sessaoID);
        request.setAttribute("saldo", saldo);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            float valorDisponivel = Float.parseFloat(request.getParameter("saldo"));
            float valorPagar = Float.parseFloat(request.getParameter("valor"));
            ClienteDao cDao = new ClienteDao();
            int sessaoID = (Integer) request.getSession(false).getAttribute("contaLogada");
            RequestDispatcher dispatcher;
            if ((valorDisponivel >= valorPagar) && (valorPagar > 0)) {
                cDao.pagar(sessaoID, valorPagar);
                dispatcher = request.getRequestDispatcher("pagamento_realizado.jsp");
                request.setAttribute("conta", sessaoID);
                request.setAttribute("valor", valorPagar);

            } else {
                dispatcher = request.getRequestDispatcher("logado_saldo_insuficiente_pagamento.jsp");
                request.setAttribute("conta", sessaoID);
                request.setAttribute("saldo", valorDisponivel);
            }
            dispatcher.forward(request, response);
    }

}
