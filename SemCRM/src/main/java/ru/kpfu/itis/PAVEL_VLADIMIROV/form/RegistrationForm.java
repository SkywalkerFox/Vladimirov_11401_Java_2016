package ru.kpfu.itis.PAVEL_VLADIMIROV.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Павел on 28.04.2016.
 */
public class RegistrationForm {
    @Size(min = 1, max = 50, message = "Имя должно содержать хотя бы одну букву")
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String firstName;

    @Size(min = 1, max = 50, message = "Фамилия должна содержать хотя бы одну букву")
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String lastName;

    @Size(min = 4, max = 50, message = "Введите корректный email")
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String email;

    @Size(min = 6, max = 50, message = "Пароль должен быть от 6 до 30 символов")
    @NotEmpty(message = "Поле обязательно для заполнения")
    private String password;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return "ROLE_USER";
    }

}
