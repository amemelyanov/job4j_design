package ru.job4j.early;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PasswordValidatorTest {

    @Test
    public void whenPasswordNull() {
        String password = null;

        assertThatThrownBy(() ->
                PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Пароль не должен быть null");
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

        assertThatThrownBy(() ->
                PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Длина пароля должна находится в диапазоне [8, 32]");

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

        assertThatThrownBy(() ->
            PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Пароль должен содержать хотя бы один символ в верхнем регистре");
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

        assertThatThrownBy(() ->
                PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Пароль должен содержать хотя бы один символ в нижнем регистре");
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

        assertThatThrownBy(() ->
                PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Пароль должен содержать хотя бы одну цифру");
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

        assertThatThrownBy(() ->
                PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Пароль должен содержать хотя бы один спец. символ (не цифра и не буква)");
    }

    @Test
    public void whenPasswordContainsSubstring() {
        String password = "_BNFGHaYUI1#qWeRty";

        assertThatThrownBy(() ->
                PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Пароль не должен содержать подстроки: qwerty, 12345, password, admin, user");
    }

    @Test
    public void whenPasswordNotContainsSubstring() {
        String password = "BNFaGHYUI$1";
        String expected = "Valid";

        String result = PasswordValidator.validate(password);
        assertThat(result).isEqualTo(expected);
    }



}