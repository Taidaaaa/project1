package model;

public class Handyman {
        private int id;
        private String name;
        private String specialization;

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
