package com.in28minutes.rest.webservices.restfulwebservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2, message = "Name should have at least 2 characters")
//    @JsonProperty("user_name")
    private String name;

    @Past(message = "Birth Date should be in the past")
//    @JsonProperty("birth_date")
    private LocalDate birthDate;

    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    List<Post> posts;
}
