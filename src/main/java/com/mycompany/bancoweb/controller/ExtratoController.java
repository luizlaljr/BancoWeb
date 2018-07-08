/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancoweb.controller;

import com.mycompany.bancoweb.dao.ClienteDao;
import com.mycompany.bancoweb.model.Movimento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ExtratoController", urlPatterns = {"/Extrato"})
public class ExtratoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Movimento> extrato = new ArrayList<>();
        ClienteDao cDao = new ClienteDao();
        int sessaoID = (Integer) request.getSession(false).getAttribute("contaLogada");
        extrato = cDao.extrato(sessaoID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("logado_extrato.jsp");
        request.setAttribute("conta", sessaoID);
        request.setAttribute("extrato", extrato);
        dispatcher.forward(request, response);
    }

}
