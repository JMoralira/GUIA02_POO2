/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.PersonasCtrl;
import com.sv.udb.modelo.Personas;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Jose Lira
 */
@MultipartConfig
@WebServlet(name = "PersonasServ", urlPatterns = {"/PersonasServ"})
public class PersonasServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean esValido = request.getMethod().equals("POST");
        String mens = "";
        if(!esValido)
        {
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
        else
        {
            String CRUD = request.getParameter("btonPers");
            if(CRUD.equals("Guardar"))
            {
            Personas obje = new Personas();
            obje.setNombrPers(request.getParameter("nomb"));
            obje.setApelPers(request.getParameter("apel"));
            Part filePart = request.getPart("ima");
            int fotoSize = (int)filePart.getSize();
            byte[] foto = null;
            foto = new byte[fotoSize];
            try(DataInputStream dataImg = new DataInputStream(filePart.getInputStream()))
            {
                dataImg.readFully(foto);
            }
            obje.setFoto(foto);
            obje.setCodiTipoPers (Integer.parseInt(request.getParameter("coditipopers")));
            obje.setGenePers(request.getParameter("gene"));
            obje.setFechaNaciPers(request.getParameter("fechnaci"));
            obje.setDuiPers(request.getParameter("dui"));
            obje.setNitPers(request.getParameter("nit"));
            obje.setTipoSangrePers(request.getParameter("tiposang"));
            obje.setCodiUbicPers(Integer.parseInt(request.getParameter("codiubicgeog")));
            obje.setCorrePers(request.getParameter("corr"));
            obje.setFechAltaPers(request.getParameter("fechalta"));
            obje.setFechBajaPers(request.getParameter("fechbaja"));
            obje.setEstaPers(Integer.parseInt(request.getParameter("esta")));
            if(new PersonasCtrl().guar(obje))
            {
                
                mens = "Datos Guardados";
            }
            else
            {
                mens = "Error al guardar";
            }
            }
            else if(CRUD.equals("Consultar"))
            {
                int codi= Integer.parseInt(request.getParameter("codiPersRadi").isEmpty() ? "-1" : request.getParameter("codiPersRadi"));
                Personas obje  = new PersonasCtrl().cons(codi);
                if(obje != null)
                {
                request.setAttribute("codi", obje.getCodiPers());                
                request.setAttribute("nomb", obje.getNombrPers());                
                request.setAttribute("apel", obje.getApelPers()); 
                request.setAttribute("coditipopers", obje.getCodiTipoPers()); 
                request.setAttribute("gene", obje.getGenePers()); 
                request.setAttribute("fechnaci", obje.getFechaNaciPers()); 
                request.setAttribute("dui", obje.getDuiPers()); 
                request.setAttribute("nit", obje.getNitPers()); 
                request.setAttribute("tiposang", obje.getTipoSangrePers()); 
                request.setAttribute("codiubicgeog", obje.getCodiUbicPers()); 
                request.setAttribute("corr", obje.getCorrePers()); 
                request.setAttribute("fechalta", obje.getFechAltaPers()); 
                request.setAttribute("fechbaja", obje.getFechBajaPers());
                request.setAttribute("esta", obje.getEstaPers());                
                request.setAttribute("ima", obje.getFoto());
                mens = "Información consultada";
                }
                else 
                {
                    mens= "Error al consultar";
                }
            }
            else if (CRUD.equals("Eliminar"))
            {
             Personas obje = new Personas();
             obje.setCodiPers(Integer.parseInt(request.getParameter("codi")));
            if(new PersonasCtrl().elim(obje))
            {
                mens = "Dato Eliminado";
            }
            else
            {
                mens = "Error al Eliminar";
            }
            }
            else if (CRUD.equals("Modificar"))
            {
                Personas obje = new Personas();
                //int codi= Integer.parseInt(request.getParameter("codi").isEmpty() ? "-1" : request.getParameter("codi"));
                //obje.setCodiEqui(codi);
            obje.setCodiPers(Integer.parseInt(request.getParameter("codi")));
            obje.setNombrPers(request.getParameter("nomb"));
            obje.setApelPers(request.getParameter("apel"));
            Part filePart = request.getPart("ima");
            int fotoSize = (int)filePart.getSize();
            byte[] foto = null;
            foto = new byte[fotoSize];
            try(DataInputStream dataImg = new DataInputStream(filePart.getInputStream()))
            {
                dataImg.readFully(foto);
            }
            obje.setFoto(foto);
            obje.setCodiTipoPers (Integer.parseInt(request.getParameter("coditipopers")));
            obje.setGenePers(request.getParameter("gene"));
            obje.setFechaNaciPers(request.getParameter("fechnaci"));
            obje.setDuiPers(request.getParameter("dui"));
            obje.setNitPers(request.getParameter("nit"));
            obje.setTipoSangrePers(request.getParameter("tiposang"));
            obje.setCodiUbicPers(Integer.parseInt(request.getParameter("codiubicgeog")));
            obje.setCorrePers(request.getParameter("corr"));
            obje.setFechAltaPers(request.getParameter("fechalta"));
            obje.setFechBajaPers(request.getParameter("fechbaja"));
            obje.setEstaPers(Integer.parseInt(request.getParameter("esta")));
                if(new PersonasCtrl().modi(obje))
                {
                    mens = "Datos Modificados";
                }
                else
                {
                    mens = "Error al Modificar";
                }
            }           
            else if(CRUD.equals("Nuevo"))
            {
                request.setAttribute("codi", "");
                request.setAttribute("nomb", "");
                request.setAttribute("apel", "");
                request.setAttribute("coditipopers", "");
                request.setAttribute("gene", "");
                request.setAttribute("fechnaci", "");
                request.setAttribute("dui", "");
                request.setAttribute("nit", "");
                request.setAttribute("tiposang", "");
                request.setAttribute("codiubicgeog", "");
                request.setAttribute("corr", "");
                request.setAttribute("fechalta", "");
                request.setAttribute("fechbaja", "");
                request.setAttribute("esta", "");
            }
            
            request.setAttribute("mensAler",mens);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

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
