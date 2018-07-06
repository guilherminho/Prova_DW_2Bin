/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import DAOs.DAOMarca;
import Entidades.Marca;
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
@WebServlet(name = "MarcaServlet", urlPatterns = {"/marca"})
public class MarcaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOs.DAOMarca produto = new DAOs.DAOMarca();
        String idMarca = "";
        
        try (PrintWriter out = response.getWriter()) {
            idMarca = request.getParameter("nomeMarca");

            String resultadoMarca = "";
            if (idMarca == null || idMarca.equals("")) {
                resultadoMarca = listaMarcasCadastrados();
            } else {
                resultadoMarca = listaMarcaNome(idMarca);
            }
            request.getSession().setAttribute("resultadoMarca", resultadoMarca);
            response.sendRedirect(request.getContextPath() + "/paginas/listaMarca.jsp");
        }
    }
    protected String listaMarcaNome(String nomeMarca) {
        DAOMarca produto = new DAOMarca();
        String resultadoMarca = "";
        List<Marca> lista = produto.listByNome(nomeMarca);
        for (Marca p : lista) {
            resultadoMarca += "<tr>"
                    + "<td>" + p.getIdMarca() + "</td>"
                    + "<td>" + p.getNome() + "</td>"
                    + "/<tr>";
        }
        return resultadoMarca;
    }

    protected String listaMarcasCadastrados() {
        DAOMarca produto = new DAOMarca();
        String resultadoMarca = "";
        List<Marca> lista = produto.listInOrderNome();
        for (Marca p : lista) {
            resultadoMarca += "<tr>"
                    + "<td>" + p.getIdMarca() + "</td>"
                    + "<td>" + p.getNome() + "</td>"
                    + "/<tr>";
        }
        return resultadoMarca;
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
