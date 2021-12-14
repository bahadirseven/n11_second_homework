package com.n11.secondhomeworkbahadirseven.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * id
 * name
 * surname
 * email
 * phone
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "kullanici")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "USER_ID_SEQ")
    @GeneratedValue(generator = "generator")
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "surname" , length = 50)
    private String surname;

    @Column(name = "email" , length = 50)
    private String email;

    @Column(name = "phone" , length = 15)
    private String phone;

    @Column(name = "username" , length = 20)
    private String username;
}
