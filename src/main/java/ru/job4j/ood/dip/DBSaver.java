package ru.job4j.ood.dip;

public class DBSaver {
    private User user;
    private DBData dbData;

    public DBSaver(User user, DBData dbData) {
        this.user = user;
        this.dbData = dbData;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DBData getDbData() {
        return dbData;
    }

    public void setDbData(DBData dbData) {
        this.dbData = dbData;
    }

    public void execute() {
        System.out.println("Connect to DataBase, User - " + user.getName());
        System.out.println("Save data - " + dbData.getData());
    }
}

class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class DBData {
    private String data;

    public DBData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}