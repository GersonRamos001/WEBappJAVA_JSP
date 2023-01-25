/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Productos;
import modelo.ProductosDAO;

@WebServlet(name = "ProductosController", urlPatterns = {"/ProductosController"})
public class ProductosController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductosController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductosController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ProductosDAO productosDao = new ProductosDAO();
        String accion;
        RequestDispatcher dispatchet = null;
        
        accion = request.getParameter("accion");
        
        if (accion == null || accion.isEmpty()) {
            dispatchet = request.getRequestDispatcher("productos/index.jsp");
            List<Productos> listaProductos = productosDao.listarProductos();
            request.setAttribute("lista", listaProductos);
            
        }else if("nuevo".equals(accion)){
            dispatchet = request.getRequestDispatcher("productos/nuevo.jsp");
            
        }else if("insertar".equals(accion)){
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio")) ;
            int existencia = Integer.parseInt(request.getParameter("existencia")) ;
  
            Productos producto = new Productos(0, existencia, codigo, nombre, precio);
            productosDao.insertar(producto); //este es el producto anterior
            dispatchet = request.getRequestDispatcher("productos/index.jsp");
            List<Productos> listaProductos = productosDao.listarProductos();
            request.setAttribute("lista", listaProductos);
        }else if("modificar".equals(accion)){
            dispatchet = request.getRequestDispatcher("productos/modificar.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Productos producto = productosDao.mostrarProducto(id);
            request.setAttribute("producto", producto);
            
            
            
            
        }else if("actualizar".equals(accion)){
            
            int id = Integer.parseInt(request.getParameter("id"));
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio")) ;
            int existencia = Integer.parseInt(request.getParameter("existencia")) ;
  
            Productos producto = new Productos(id, existencia, codigo, nombre, precio);
            productosDao.actualizar(producto); //este es el producto anterior
            dispatchet = request.getRequestDispatcher("productos/index.jsp");
            List<Productos> listaProductos = productosDao.listarProductos();
            request.setAttribute("lista", listaProductos);
        }else if("eliminar".equals(accion)){
            
            int id = Integer.parseInt(request.getParameter("id"));

            productosDao.eliminar(id); //este es el producto anterior
            dispatchet = request.getRequestDispatcher("productos/index.jsp");
            List<Productos> listaProductos = productosDao.listarProductos();
            request.setAttribute("lista", listaProductos);
        }else{
            dispatchet = request.getRequestDispatcher("productos/index.jsp");
            List<Productos> listaProductos = productosDao.listarProductos();
            request.setAttribute("lista", listaProductos);
        }
            
        dispatchet.forward(request, response);

    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        doGet(request,response); //configaramos

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
