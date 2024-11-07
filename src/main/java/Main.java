
import java.sql.Connection;
import java.sql.SQLException;

import menu.MainMenu;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            MainMenu menu = new MainMenu(connection);
            menu.displayMenu();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


