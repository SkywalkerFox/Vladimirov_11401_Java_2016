package ru.kpfu.itis.PAVEL_VLADIMIROV.controllers;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kpfu.itis.PAVEL_VLADIMIROV.models.Article;
import ru.kpfu.itis.PAVEL_VLADIMIROV.repository.ArticlesRepository;
import ru.kpfu.itis.PAVEL_VLADIMIROV.repository.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by ����� on 11.11.2015.
 */
@WebServlet(name = "ArticleItemServlet")
public class ArticleItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        ArticlesRepository articlesRepository = ac.getBean(ArticlesRepository.class);

        if (session.getAttribute("current_user") != null) {
            try {
                Configuration cfg = ConfigSingleton.getConfig(getServletContext());
                Template tmp1 = cfg.getTemplate("articleitem.ftl");
                HashMap<String, Object> root = new HashMap<>();
                Article article = articlesRepository.getArticleByTitle(request.getPathInfo().substring(1));
                root.put("form_url", request.getRequestURI());
                root.put("article", article);
                root.put("username", UsersRepository.getUserByEmail((String) session.getAttribute("current_user")).getName());

                tmp1.process(root, response.getWriter());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/login");
        }
    }
}
