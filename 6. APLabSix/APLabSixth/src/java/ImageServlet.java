/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.annotation.WebServlet;
import javax.imageio.ImageIO;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
//import javax.servlet.annotation.WebServlet;

/**
 *
 * @author kami
 */
@WebServlet(urlPatterns = {"/hello.png"})
public class ImageServlet extends HttpServlet {
    
    private static final String IMAGE_CONTENT_TYPE = "image/jpeg";
    
    private static final int WIDTH = 640;
    private static final int HEIGHT = 120;
    
    private static final String TEXT = "Hello, World!";
    private static final String FONT_NAME = "Arial";
    private static final int FONT_SIZE = 72;
    
    private static final int X = 100;
    private static final int Y = 100;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        
        response.setContentType(IMAGE_CONTENT_TYPE);
        
        try (ServletOutputStream out = response.getOutputStream()) {
            BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
            
            Graphics graphics = image.getGraphics();
            graphics.setFont(new Font(FONT_NAME, Font.BOLD, FONT_SIZE));
            Random random = new Random();
            graphics.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            
            graphics.drawString(TEXT, X, Y);
            ImageIO.write(image, "jpeg", out);
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response){

}
}
