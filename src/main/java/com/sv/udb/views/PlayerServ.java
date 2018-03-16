/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.views;

import com.sv.udb.controller.PlayerController;
import com.sv.udb.controller.TeamController;
import com.sv.udb.model.Player;
import com.sv.udb.model.Team;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevin
 */
@WebServlet(name = "PlayerServ", urlPatterns = {"/PlayerServ"})
public class PlayerServ extends HttpServlet {

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
        try {
            boolean isValid = request.getMethod().equals("POST");
            String message = "";
            if(!isValid) {
                response.sendRedirect(request.getContextPath() + "/player.jsp");
            }
            else {
                String CRUD = request.getParameter("playerBtn");
                if(CRUD.equals("Guardar")) {
                    Team team = new TeamController().get(Integer.parseInt(request.getParameter("team")));
                    if (new PlayerController().save(team, request.getParameter("name"), Integer.parseInt(request.getParameter("age")), 
                            Double.parseDouble(request.getParameter("height")), Double.parseDouble(request.getParameter("weight"))))
                        message = "Datos guardados";
                    else 
                        message = "Error al guardar";
                }

                else if (CRUD.equals("Consultar")) {
                    int code = Integer.parseInt(request.getParameter("playerCodeRadio") == null ? "-1" : request.getParameter("playerCodeRadio"));
                    Player player = new PlayerController().get(code);
                    if (player != null) {
                        request.setAttribute("code", player.getCode());
                        request.setAttribute("name", player.getName());
                        request.setAttribute("age", player.getAge());
                        request.setAttribute("height", player.getHeight());
                        request.setAttribute("weight", player.getWeight());
                        request.setAttribute("team", player.getTeam().getCode());

                        message = "Información consultada";

                        request.setAttribute("update", "true");
                    }
                    else
                        message = "Error al consultar";
                }

                else if (CRUD.equals("Modificar")) {
                    Team team = new TeamController().get(Integer.parseInt(request.getParameter("team")));
                    if (new PlayerController().update(Integer.parseInt(request.getParameter("code")), team, request.getParameter("name"), 
                            Integer.parseInt(request.getParameter("age")), Double.parseDouble(request.getParameter("height")), 
                            Double.parseDouble(request.getParameter("weight"))))
                        message = "Datos modificados";
                    else
                        message = "Error al modificar";
                }

                else if (CRUD.equals("Eliminar")) {
                    if (new PlayerController().delete(Integer.parseInt(request.getParameter("code"))))
                        message = "Datos eliminados";
                    else
                        message = "Error al eliminar";
                }

                request.setAttribute("message", message);
                request.getRequestDispatcher("/player.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new ServletException(e);
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
