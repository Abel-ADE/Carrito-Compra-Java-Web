/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import beans.Producto;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "VerCarrito", urlPatterns = {"/VerCarrito"})
public class VerCarrito extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        //Recupero la sesión y el carrito de la sesión
        HttpSession session = req.getSession();
        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

        if (carrito != null) {
            String head = "<html lang='es'>"
                    + "     <head>\n"
                    + "        <title>Carrito</title>\n"
                    + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                    + "        <style>\n"
                    + "        * {\n"
                    + "            padding: 0px;\n"
                    + "            margin: 0px;\n"
                    + "            box-sizing: border-box;\n"
                    + "            font-family: Arial, Helvetica, sans-serif;\n"
                    + "        }\n"
                    + "\n"
                    + "        body {\n"
                    + "            display: flex;\n"
                    + "            flex-direction: column;\n"
                    + "            align-items: center;\n"
                    + "            justify-content: center;\n"
                    + "            gap: 30px;\n"
                    + "            padding: 30px;\n"
                    + "            color: black;\n"
                    + "        }\n"
                    + "\n"
                    + "        .buttons {\n"
                    + "            display: flex;\n"
                    + "            flex-direction: row;\n"
                    + "            gap: 30px;\n"
                    + "\n"
                    + "        }\n"
                    + "\n"
                    + "        .button {\n"
                    + "            width: 180px;\n"
                    + "            padding: 10px 20px;\n"
                    + "            border-radius: 5px;\n"
                    + "            background-color: #007bff;\n"
                    + "            color: white;\n"
                    + "            text-decoration: none;\n"
                    + "            text-align: center;\n"
                    + "            font-weight: bold;\n"
                    + "            font-size: 16px;\n"
                    + "            cursor: pointer;\n"
                    + "            display: flex;\n"
                    + "            align-items: center;\n"
                    + "            justify-content: center;\n"
                    + "        }\n"
                    + "\n"
                    + "        .button:hover {\n"
                    + "            transform: scale(1.02);\n"
                    + "            -webkit-transform: scale(1.02);\n"
                    + "            -moz-transform: scale(1.02);\n"
                    + "            -ms-transform: scale(1.02);\n"
                    + "            -o-transform: scale(1.02);\n"
                    + "        }\n"
                    + "\n"
                    + "        .button:active {\n"
                    + "            transform: scale(1);\n"
                    + "            -webkit-transform: scale(1);\n"
                    + "            -moz-transform: scale(1);\n"
                    + "            -ms-transform: scale(1);\n"
                    + "            -o-transform: scale(1);\n"
                    + "        }\n"
                    + "\n"
                    + "        h1 {\n"
                    + "            color: #007bff;\n"
                    + "        }\n"
                    + "\n"
                    + "        .container{\n"
                    + "            display: flex;\n"
                    + "            flex-direction: column;\n"
                    + "            gap: 40px;\n"
                    + "            text-align: center;"
                    + "        }\n"
                    + "\n"
                    + "        .table {\n"
                    + "            width: 100%;\n"
                    + "            border-collapse: collapse;\n"
                    + "            border: 1px solid gray;\n"
                    + "        }\n"
                    + "\n"
                    + "        .table th {\n"
                    + "            background-color: #007bff;\n"
                    + "            color: white;\n"
                    + "            padding: 10px;\n"
                    + "            text-align: center;\n"
                    + "            border-right: 1px solid white;\n"
                    + "        }\n"
                    + "\n"
                    + "        .table th:last-child {\n"
                    + "            border-right: none;\n"
                    + "        }\n"
                    + "\n"
                    + "        .table td {\n"
                    + "            padding: 10px;\n"
                    + "            text-align: center;\n"
                    + "            border: 1px solid gray;\n"
                    + "        }\n"
                    + "\n"
                    + "        .eliminar {\n"
                    + "            text-decoration: none;\n"
                    + "            color:#DC3545;\n"
                    + "        }\n"
                    + "     </style>"
                    + "     </head>";

            String body = "<body>"
                    + "         <div class='container'>"
                    + "          <h1>Carrito</h1>";

            String tableHead = "<table class='table'> "
                    + "         <thead> "
                    + "             <tr> "
                    + "                 <th>Producto</th> "
                    + "                 <th>Unidades</th> "
                    + "                 <th>Precio</th> "
                    + "                 <th></th>"
                    + "             </tr> "
                    + "         </thead> "
                    + "         <tbody> ";

            String row = "";
            for (int i = 0; i < carrito.size(); i++) {
                Producto producto = carrito.get(i);
                row += "    <tr>"
                        + "     <td>" + producto.getName() + "</td>"
                        + "     <td>" + producto.getUnits() + "</td>"
                        + "     <td>" + producto.getPrice() + "</td>"
                        + "     <td> <a class='eliminar' href='Eliminar?pos=" + i + "'> Eliminar </a> </td>"
                        + "  </tr>";
            }

            String tableFooter = "</tbody> </table>";

            String butons = "<div class=\"buttons\">\n"
                    + "            <a class=\"button\" style=\"background-color:#28A745;\" href='index.html'>Volver</a>\n"
                    + "            <a class=\"button\"  style=\"background-color:#FFC107;\"  href='Vaciar'>Vaciar</a>\n"
                    + "            <a class=\"button\"  style=\"background-color:#DC3545;\" href='Cerrar'>Desconectar</a>\n"
                    + "        </div>";

            String closeHtml = "</div> </body> </html>";

            out.print(head + body + tableHead + row + tableFooter + butons + closeHtml);

        } else {
            //Vuelvo a la página opciones
            req.getRequestDispatcher("index.html").forward(req, resp);
        }
    }

}
