package com.Housing.Bias.dto;

import com.Housing.Bias.entity.House;
import com.Housing.Bias.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDTO {

    private String name;

    private String email;

    private String registrationType;

}
