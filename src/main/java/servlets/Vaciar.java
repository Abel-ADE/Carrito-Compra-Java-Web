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
@WebServlet(name = "Vaciar", urlPatterns = {"/Vaciar"})
public class Vaciar extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //Recupero la sesión y elimino el carrito de la sesión
        HttpSession session = req.getSession();
        session.removeAttribute("carrito");
        
        //Vuelvo a la página opciones
        req.getRequestDispatcher("index.html").forward(req, resp);
    }

    
}
