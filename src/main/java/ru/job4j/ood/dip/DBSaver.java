package ru.job4j.ood.dip;

public class DBSaver {
    User user;
    DBData dbData;

    public DBSaver(User user, DBData dbData) {
        this.user = user;
        this.dbData = dbData;
    }

    public void execute() {
        System.out.println("Connect to DataBase, User - " + user.name);
        System.out.println("Save data - " + dbData.data);
    }
}

class User {
    String name;
    String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}

class DBData {
    String data;

    public DBData(String data) {
        this.data = data;
    }
}