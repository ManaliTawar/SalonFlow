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


}
