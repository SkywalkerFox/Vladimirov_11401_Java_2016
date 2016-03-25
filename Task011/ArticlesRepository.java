package ru.kpfu.itis.PAVEL_VLADIMIROV.repository;


import org.json.JSONArray;
import ru.kpfu.itis.PAVEL_VLADIMIROV.MyConnection;
import ru.kpfu.itis.PAVEL_VLADIMIROV.models.Article;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by ����� on 11.11.2015.
 */
public class ArticlesRepository {

    public static ArrayList<Article> getArticles() throws SQLException, ClassNotFoundException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM articles");
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Article> listOfArticles = new ArrayList<>();

        while (resultSet.next()) {
            Article article = new Article(resultSet.getString("title"), resultSet.getString("photo"), resultSet.getString("reference"), resultSet.getString("description"));
            listOfArticles.add(article);
        }

        return listOfArticles;
    }

    public static boolean isArticleContains(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT title FROM articles WHERE title LIKE ?");
        statement.setString(1, request.getParameter("title"));
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next();
    }

    public static void addNewArticle(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO articles VALUES(DEFAULT, ?, ?, ?, ?)");
        statement.setString(1, request.getParameter("photo"));
        statement.setString(2, request.getParameter("ascension") + ";\n" + request.getParameter("declination") + ";\n"
                + request.getParameter("classification") + ";");
        statement.setString(3, request.getParameter("description"));
        statement.setString(4, request.getParameter("title"));
        statement.execute();
    }

    public Article getArticleByTitle(String title) throws SQLException, ClassNotFoundException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM articles WHERE title LIKE ?");
        statement.setString(1, title);
        ResultSet resultSet = statement.executeQuery();
        Article article = null;
        if (resultSet.next()) {
            article = new Article(resultSet.getString("title"), resultSet.getString("photo"),
                    resultSet.getString("reference"), resultSet.getString("description"));
        }
        return article;
    }

    public static JSONArray getArticlesByKeyWord(String keyword) {
        JSONArray jsonArray = new JSONArray();
        return jsonArray;
    }
}
