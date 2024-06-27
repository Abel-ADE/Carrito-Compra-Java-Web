package servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import beans.Producto;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/Comprar"})
public class Comprar extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Recupero la sesión
        HttpSession session = req.getSession();
        
        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");
        
        if (carrito == null) {
            carrito = new ArrayList<>();
            session.setAttribute("carrito", carrito);
        }
        
        //Recupero parámetros
        String name = req.getParameter("name");
        int units = Integer.parseInt(req.getParameter("units"));
        double price = Double.parseDouble(req.getParameter("price"));
        
        //Añado el producto al carrito
        carrito.add(new Producto(name, units, price));
        
        //Vuelvo a la página opciones
        req.getRequestDispatcher("index.html").forward(req, resp);
        
        
    }

    
}
