package service;

import model.Handyman;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HandymanService {

    private final Connection connection;

    public HandymanService(Connection connection) {
        this.connection = connection;
    }

    public void addHandyman(Handyman handyman) {
        String query = "INSERT INTO handymen (name, specialization) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, handyman.getName());
            statement.setString(2, handyman.getSpecialization());
            statement.executeUpdate();
            System.out.println("Майстра додано в базу: " + handyman);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateHandyman(int id, Handyman updatedHandyman) {
        String query = "UPDATE handymen SET name = ?, specialization = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, updatedHandyman.getName());
            statement.setString(2, updatedHandyman.getSpecialization());
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println("Інформацію про майстра оновлено: " + updatedHandyman);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHandyman(int id) {
        String query = "DELETE FROM handymen WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Майстра з id " + id + " видалено.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Handyman> searchBySpecialization(String specialization) {
        List<Handyman> result = new ArrayList<>();
        String query = "SELECT * FROM handymen WHERE specialization = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, specialization);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                result.add(new Handyman(id, name, specialization));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Handyman> getAllHandymen() {
        List<Handyman> handymen = new ArrayList<>();
        String query = "SELECT * FROM handymen";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                handymen.add(new Handyman(id, name, specialization));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return handymen;
    }
}


