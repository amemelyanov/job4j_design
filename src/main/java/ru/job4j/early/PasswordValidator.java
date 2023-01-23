package ru.job4j.early;

import java.util.List;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Пароль не должен быть null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Длина пароля должна находится в диапазоне [8, 32]");
        }
        if (!isContainsUpperCaseChar(password)) {
            throw new IllegalArgumentException(
                    "Пароль должен содержать хотя бы один символ в верхнем регистре");
        }
        if (!isContainsLowercaseChar(password)) {
            throw new IllegalArgumentException(
                    "Пароль должен содержать хотя бы один символ в нижнем регистре");
        }
        if (!isContainsDigit(password)) {
            throw new IllegalArgumentException(
                    "Пароль должен содержать хотя бы одну цифру");
        }
        if (!isContainsSpecialChar(password)) {
            throw new IllegalArgumentException(
                    "Пароль должен содержать хотя бы один спец. символ (не цифра и не буква)");
        }
        if (!isNotContainsSubstring(password)) {
            throw new IllegalArgumentException(
                    "Пароль не должен содержать подстроки: qwerty, 12345, password, admin, user");
        }
        return "Valid";
    }

    private static boolean isContainsUpperCaseChar(String password) {
        for (Character c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isContainsLowercaseChar(String password) {
        for (Character c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isContainsDigit(String password) {
        for (Character c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isContainsSpecialChar(String password) {
        for (Character c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNotContainsSubstring(String password) {
        List<String> substring = List.of("qwerty", "12345", "password", "admin", "user");
        for (String s : substring) {
            if (password.toLowerCase().contains(s)) {
                return false;
            }
        }
        return true;
    }

}
