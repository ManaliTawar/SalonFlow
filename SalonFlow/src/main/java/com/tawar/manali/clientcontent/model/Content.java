package com.tawar.manali.clientcontent.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;


public record Content(
        @Id
        Integer id,
        @NotBlank
        String name,

        String contact,
        String emailId,
        String occupation,
        LocalDateTime checkin,
        LocalDateTime checkout,
        LocalDate dob
) {
        @Override
        public Integer id() {
                return id;
        }

        @Override
        public String name() {
                return name;
        }

        @Override
        public String contact() {
                return contact;
        }

        @Override
        public String emailId() {
                return emailId;
        }

        @Override
        public String occupation() {
                return occupation;
        }

        @Override
        public LocalDateTime checkin() {
                return checkin;
        }

        @Override
        public LocalDateTime checkout() {
                return checkout;
        }

        @Override
        public LocalDate dob() {
                return dob;
        }
}
