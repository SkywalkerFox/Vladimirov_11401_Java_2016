package ru.kpfu.itis.PAVEL_VLADIMIROV.repository;

import org.json.JSONArray;
import ru.kpfu.itis.PAVEL_VLADIMIROV.MyConnection;
import ru.kpfu.itis.PAVEL_VLADIMIROV.models.Photo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by ����� on 12.11.2015.
 */
public class PhotosRepository {

    public static ArrayList<Photo> getAllImages() throws SQLException, ClassNotFoundException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM photos");
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Photo> listOfImages = new ArrayList<>();

        while (resultSet.next()) {
            Photo image = new Photo(resultSet.getString("prooflink"), resultSet.getString("description"));
            listOfImages.add(image);
        }

        return listOfImages;
    }

    public void addImage(Photo image) throws SQLException, ClassNotFoundException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO photos VALUES (DEFAULT , ?, ?, ?)");
        statement.setString(1,image.getURL());
        statement.setString(2, image.getDescription());
        statement.setString(3, "");
        statement.execute();
    }

    public static JSONArray getPhotosByKeyWord(String keyword) {
        JSONArray jsonArray = new JSONArray();
        return jsonArray;
    }
}
