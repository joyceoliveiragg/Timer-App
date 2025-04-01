package me.dio.App.ProjectTimer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserInfo {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String contract;
        private String sector;
        private String hours;
        private String manager;
        private String project;
        private String email;
        private String password;

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getContract() { return contract; }
        public void setContract(String contract) { this.contract = contract; }
        public String getSector() { return sector; }
        public void setSector(String sector) { this.sector = sector; }
        public String getHours() { return hours; }
        public void setHours(String hours) { this.hours = hours; }
        public String getManager() { return manager; }
        public void setManager(String manager) { this.manager = manager; }
        public String getProject() { return project; }
        public void setProject(String project) { this.project = project; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
}
