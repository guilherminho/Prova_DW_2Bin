/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOProduto;
import Entidades.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author a1711997
 */
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/listaProduto"})
public class ProdutoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOs.DAOProduto produto = new DAOs.DAOProduto();
        String idProduto = "";
        
        try (PrintWriter out = response.getWriter()) {
            idProduto = request.getParameter("nomeProduto");

            String resultadoProduto = "";
            if (idProduto == null || idProduto.equals("")) {
                resultadoProduto = listaProdutosCadastrados();
            } else {
                resultadoProduto = listaProdutoNome(idProduto);
            }
            request.getSession().setAttribute("resultadoProduto", resultadoProduto);
            response.sendRedirect(request.getContextPath() + "/paginas/listaProduto.jsp");
        }
    }
    protected String listaProdutoNome(String nomeProduto) {
        DAOProduto produto = new DAOProduto();
        String resultadoProduto = "";
        List<Produto> lista = produto.listByNome(nomeProduto);
        for (Produto p : lista) {
                resultadoProduto += "<tr>"
                        + "<td>" + p.getIdProduto() + "</td>"
                        + "<td>" + p.getNome() + "</td>"
                        + "<td>" + p.getPreco() + "</td>"
                        + "<td>" + p.getDescricao() + "</td>"
                        + "<td>" + p.getIdTipo() + "</td>"
                        + "<td>" + p.getIdMarca() + "</td>"
                        + "</tr>";
            }     
        return resultadoProduto;
    }
    protected String listaProdutosCadastrados() {
        DAOProduto produto = new DAOProduto();
        String resultadoProduto = "";
        List<Produto> lista = produto.listInOrderNome();
        for (Produto p : lista) {
                resultadoProduto += "<tr>"
                        + "<td>" + p.getIdProduto() + "</td>"
                        + "<td>" + p.getNome() + "</td>"
                        + "<td>" + p.getPreco() + "</td>"
                        + "<td>" + p.getDescricao() + "</td>"
                        + "<td>" + p.getIdTipo() + "</td>"
                        + "<td>" + p.getIdMarca() + "</td>"
                        + "</tr>";
            }     
        return resultadoProduto;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
