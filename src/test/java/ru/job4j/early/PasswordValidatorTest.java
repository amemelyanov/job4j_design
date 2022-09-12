package ru.job4j.early;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PasswordValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenPasswordNull() {
        PasswordValidator.validate(null);
    }

    @Test
    public void whenPasswordLengthIsValid() {
        String password = "_BNFGHaYUI1#";
        String expected = "Valid";

        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenPasswordLengthLessThanNeed() {
        String password = "_HYUI1#";
        String expected = "Длина пароля должна находится в диапазоне [8, 32]";

        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenPasswordContainsUpperCaseChar() {
        String password = "_BNFGHaYUI1#";
        String expected = "Valid";

        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenPasswordNotContainsUpperCaseChar() {
        String password = "_bnfgh1#";
        String expected = "Пароль должен содержать хотя бы один символ в верхнем регистре";

        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenPasswordContainsLowerCaseChar() {
        String password = "_BNFGHaYUI1#";
        String expected = "Valid";

        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenPasswordNotContainsLowerCaseChar() {
        String password = "_BNFGHYUI1#";
        String expected = "Пароль должен содержать хотя бы один символ в нижнем регистре";

        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenPasswordContainsDigit() {
        String password = "_BNFGHaYUI1#";
        String expected = "Valid";

        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenPasswordNotContainsDigit() {
        String password = "_BNFaGHYUI#";
        String expected = "Пароль должен содержать хотя бы одну цифру";

        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenPasswordContainsSpecialChar() {
        String password = "_BNFGHaYUI1#";
        String expected = "Valid";

        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenPasswordNotContainsSpecialChar() {
        String password = "BNFaGHYUI1";
        String expected = "Пароль должен содержать хотя бы один спец. символ (не цифра и не буква)";

        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenPasswordContainsSubstring() {
        String password = "_BNFGHaYUI1#qWeRty";
        String expected = "Пароль не должен содержать подстроки: qwerty, 12345, password, admin, user";

        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenPasswordNotContainsSubstring() {
        String password = "BNFaGHYUI$1";
        String expected = "Valid";

        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }



}