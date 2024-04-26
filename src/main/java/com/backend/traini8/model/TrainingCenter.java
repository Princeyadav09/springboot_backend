package com.backend.traini8.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Center name cannot be null")
    @Size(min = 3, max = 40, message = "Center name must be between 3 and 40 characters")
    @Column(nullable = false)
    private String centerName;

    @NotNull(message = "Center code cannot be null")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")
    @Column(nullable = false, length = 12)
    private String centerCode;

    @Embedded
    @NotNull(message = "Address cannot be null")
    private Address address;

    @Positive(message = "Student capacity must be positive")
    private Integer studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    @Column(nullable = false)
    private Long createdOn;

    @Email(message = "Enter a valid email address")
    private String email;

    @NotNull(message = "Contact phone number cannot be null")
    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Enter a valid phone number with 7 to 15 digits, optionally starting with a +")
    @Column(nullable = false)
    private String contactPhone;

}
