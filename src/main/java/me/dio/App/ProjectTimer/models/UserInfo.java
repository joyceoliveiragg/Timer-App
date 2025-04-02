package me.dio.App.ProjectTimer.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class UserInfo {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true) // Mantido como restrição de banco
        private String email;

        @Column(unique = true)
        private String employeeId;

        private String password;
        private String role;
        private String contractType;
        private String sector;
        private String manager;
        private String weeklyWorkload;
        private LocalDate hireDate;

        @OneToOne(mappedBy = "userInfo")
        private User user;

        // Getters e Setters

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getEmployeeId() { return employeeId; }
        public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }

        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }

        public String getContractType() { return contractType; }
        public void setContractType(String contractType) { this.contractType = contractType; }

        public String getSector() { return sector; }
        public void setSector(String sector) { this.sector = sector; }

        public String getManager() { return manager; }
        public void setManager(String manager) { this.manager = manager; }

        public String getWeeklyWorkload() { return weeklyWorkload; }
        public void setWeeklyWorkload(String weeklyWorkload) { this.weeklyWorkload = weeklyWorkload; }

        public LocalDate getHireDate() { return hireDate; }
        public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }

        public User getUser() { return user; }
        public void setUser(User user) { this.user = user; }
}