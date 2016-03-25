package ru.kpfu.itis.PAVEL_VLADIMIROV.controllers;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.PAVEL_VLADIMIROV.models.Photo;
import ru.kpfu.itis.PAVEL_VLADIMIROV.repository.PhotosRepository;
import ru.kpfu.itis.PAVEL_VLADIMIROV.repository.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ����� on 12.11.2015.
 */
@WebServlet(name = "PhotoServlet")
public class PhotoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");

        if (session.getAttribute("current_user") != null) {

            try {
                Photo image = new Photo(request.getParameter("URL"), request.getParameter("description"));
                PhotosRepository photosRepository = ac.getBean(PhotosRepository.class);
                photosRepository.addImage(image);
                response.sendRedirect("/photo");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        if (session.getAttribute("current_user") != null) {
            try {
                Configuration cfg = ConfigSingleton.getConfig(getServletContext());
                Template tmp1 = cfg.getTemplate("photo.ftl");
                HashMap<String, Object> root = new HashMap<>();
                ArrayList<Photo> listOfImages = PhotosRepository.getAllImages();
                root.put("form_url", request.getRequestURI());
                root.put("images", listOfImages);
                root.put("username", UsersRepository.getUserByEmail((String) session.getAttribute("current_user")).getName());

                tmp1.process(root, response.getWriter());
            } catch (TemplateException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/login");
        }
    }
}

