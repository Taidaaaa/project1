package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity  // Вказуємо, що цей клас є сутністю для Hibernate
@Table(name = "handymen")  // Вказуємо назву таблиці в базі даних
public class Handyman {

        @Id  // Вказуємо, що це поле є первинним ключем
        @GeneratedValue(strategy = GenerationType.IDENTITY)  // Вказуємо автоматичну генерацію значень для ID
        @Column(name = "id")  // Вказуємо назву колонки для цього поля
        private int id;

        @Column(name = "name", nullable = false)  // Поле обов’язкове для заповнення (не може бути NULL)
        private String name;

        @Column(name = "specialization")  // Можна додати додаткові параметри, якщо потрібно
        private String specialization;

        // Конструктор без параметрів, обов'язковий для Hibernate
        public Handyman() {}

        // Конструктор з параметрами (можна використовувати для зручності)
        public Handyman(int id, String name, String specialization) {
                this.id = id;
                this.name = name;
                this.specialization = specialization;
        }

        // Getters and Setters
        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getSpecialization() {
                return specialization;
        }

        public void setSpecialization(String specialization) {
                this.specialization = specialization;
        }

        @Override
        public String toString() {
                return "Handyman [ID=" + id + ", Name=" + name + ", Specialization=" + specialization + "]";
        }
}
