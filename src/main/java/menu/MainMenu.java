package menu;

import model.Handyman;
import service.HandymanService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private final HandymanService handymanService;
    private final Scanner scanner = new Scanner(System.in);

    public MainMenu(Connection connection) {
        this.handymanService = new HandymanService(connection);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\n--- Майстер на годину ---");
            System.out.println("1. Додати майстра");
            System.out.println("2. Оновити інформацію про майстра");
            System.out.println("3. Видалити майстра");
            System.out.println("4. Пошук майстра за спеціалізацією");
            System.out.println("5. Вивести всіх майстрів");
            System.out.println("0. Вийти");

            System.out.print("Оберіть дію: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addHandyman();
                    break;
                case 2:
                    updateHandyman();
                    break;
                case 3:
                    deleteHandyman();
                    break;
                case 4:
                    searchBySpecialization();
                    break;
                case 5:
                    displayAllHandymen();
                    break;
                case 0:
                    System.out.println("Вихід з програми.");
                    return;
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
            }
        }
    }

    // Метод для додавання нового майстра
    private void addHandyman() {
        System.out.print("Введіть ім'я майстра: ");
        String name = scanner.nextLine();
        System.out.print("Введіть спеціалізацію майстра: ");
        String specialization = scanner.nextLine();

        Handyman handyman = new Handyman(0, name, specialization); // '0' для ID, який згенерує БД
        handymanService.addHandyman(handyman);
    }

    // Метод для оновлення інформації про майстра
    private void updateHandyman() {
        System.out.print("Введіть ID майстра для оновлення: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // очищення сканера
        System.out.print("Введіть нове ім'я майстра: ");
        String name = scanner.nextLine();
        System.out.print("Введіть нову спеціалізацію майстра: ");
        String specialization = scanner.nextLine();

        Handyman updatedHandyman = new Handyman(id, name, specialization);
        handymanService.updateHandyman(id, updatedHandyman);
    }

    // Метод для видалення майстра
    private void deleteHandyman() {
        System.out.print("Введіть ID майстра для видалення: ");
        int id = scanner.nextInt();
        handymanService.deleteHandyman(id);
    }

    // Метод для пошуку майстра за спеціалізацією
    private void searchBySpecialization() {
        System.out.print("Введіть спеціалізацію для пошуку: ");
        String specialization = scanner.nextLine();
        List<Handyman> handymen = handymanService.searchBySpecialization(specialization);

        if (handymen.isEmpty()) {
            System.out.println("Майстрів з такою спеціалізацією не знайдено.");
        } else {
            System.out.println("Знайдені майстри:");
            handymen.forEach(System.out::println);
        }
    }

    // Метод для виведення всіх майстрів
    private void displayAllHandymen() {
        List<Handyman> handymen = handymanService.getAllHandymen();

        if (handymen.isEmpty()) {
            System.out.println("Немає майстрів для відображення.");
        } else {
            System.out.println("Список всіх майстрів:");
            handymen.forEach(System.out::println);
        }
    }
}


