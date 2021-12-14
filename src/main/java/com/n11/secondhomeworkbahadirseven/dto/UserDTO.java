package com.n11.secondhomeworkbahadirseven.dto;

import com.n11.secondhomeworkbahadirseven.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String username;

    public static UserDTO fromUser(User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .phone(user.getPhone())
                .username(user.getUsername())
                .build();
    }

    public static User fromUserDTO(UserDTO userDTO){
        return User.builder()
                .name(userDTO.getName())
                .surname(userDTO.getSurname())
                .email(userDTO.getEmail())
                .phone(userDTO.getPhone())
                .username(userDTO.getUsername())
                .build();
    }
}
