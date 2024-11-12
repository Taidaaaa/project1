import java.sql.Connection;
import java.sql.SQLException;

import config.SpringConfig;
import service.HandymanService;
import menu.MainMenu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Ініціалізація Spring контексту
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class)) {
            // Отримуємо екземпляри через Spring
            HandymanService handymanService = context.getBean(HandymanService.class);
            Connection connection = DatabaseConnection.getConnection();

            // Створюємо MainMenu з ін'єкцією залежностей
            MainMenu menu = new MainMenu(connection, handymanService);
            menu.displayMenu();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
