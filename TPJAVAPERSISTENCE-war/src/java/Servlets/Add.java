/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Cours.Cours;
import Persistence.CoursFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AYGTX
 */
@WebServlet(name = "Add")
public class Add extends HttpServlet {

    @EJB
    private CoursFacadeLocal coursFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Add</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Add at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String matiere = request.getParameter("matiere");
        String url = request.getParameter("url");
        String description = request.getParameter("description");
        try ( PrintWriter out = response.getWriter()) {
            try {
                Cours c = new Cours();
                c.setId(id);
                c.setDescription(description);
                c.setMatiere(matiere);
                c.setNom(nom);
                c.setUrl(url);
                coursFacade.create(c);
                out.println("add with success");
            } catch (Exception ex) {
                out.println("err");
                out.println(ex.toString());
            }

            {

            }

        } catch (Exception e) {
            System.out.println("eee" + e.toString());
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
