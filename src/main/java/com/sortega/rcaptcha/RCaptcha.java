package com.sortega.rcaptcha;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sortega
 */
public class RCaptcha extends HttpServlet {
    private long graceTime;

    private long timeout = 0;
    private long result = 0;
    private String challenge = "";
    private RandomTreeGenerator generator;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.graceTime = Long.parseLong(
                this.getServletConfig().getInitParameter("grace_time"));
        this.generator = new RandomTreeGenerator();
    }

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        if (System.currentTimeMillis() > timeout) {
            replaceChallenge();
        }

        request.setAttribute("remaining_millis", 
                this.timeout - System.currentTimeMillis());
        request.setAttribute("challenge", this.challenge);

        doView("challenge", request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        if (System.currentTimeMillis() > timeout) {
            request.setAttribute("message",
                    "Your response was not expected so late. " +
                    "Are you hypertrashing or are you a human?");
            doView("wrong", request, response);
        } else {
            String receivedStrinResult = request.getParameter("result");
            try {
                long receivedResult = Long.parseLong(receivedStrinResult, 10);
                if (receivedResult == result) {
                    doView("success", request, response);
                } else {
                    request.setAttribute("message", "Hello unreliable human!");
                    doView("wrong", request, response);
                }

            } catch (NumberFormatException ex) {
                request.setAttribute("message",
                        "Humans couldn't tell apart an integer from a character...");
                doView("wrong", request, response);
            }
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Reverse CAPTCHA test servlet";
    }

    private void replaceChallenge() {
        this.timeout = System.currentTimeMillis() + this.graceTime;

        Node expression = this.generator.generateTree(10);
        this.challenge = expression.toString();
        this.result = expression.getValue();
    }

    private void doView(String view, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/pages/" + view + ".jsp")
                .forward(request, response);
    }
}
