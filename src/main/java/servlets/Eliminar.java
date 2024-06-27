/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import beans.Producto;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "Eliminar", urlPatterns = {"/Eliminar"})
public class Eliminar extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Recupero la sesión y el carrito de la sesión
        HttpSession session = req.getSession();
        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");
        
        if (carrito!=null) {
            int pos = Integer.parseInt(req.getParameter("pos"));
            carrito.remove(pos);
        }
        
        req.getRequestDispatcher("VerCarrito").forward(req, resp);
        
    }

    
}
