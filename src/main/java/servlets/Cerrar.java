/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author abel
 */
@WebServlet(name = "Cerrar", urlPatterns = {"/Cerrar"})
public class Cerrar extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //Recupero la sesión y la elimino
        HttpSession session = req.getSession();
        session.invalidate();
        
        //Devuelvo a la página de opciones
        req.getRequestDispatcher("index.html").forward(req, resp);
    }

    
}
