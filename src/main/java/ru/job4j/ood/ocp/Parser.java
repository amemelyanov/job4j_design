package ru.job4j.ood.ocp;

public class Parser {
    private TxtSaver txtsaver;
    private String data;

    public Parser(TxtSaver txtsaver) {
        this.txtsaver = txtsaver;
    }

    public void getData(String source) {
        data = source;
    }

    public void saveData() {
        txtsaver.saveToTxtFile(data);
    }

}

class TxtSaver {
    public void saveToTxtFile(String data) {
        System.out.println("Save to txt file");
    }
}
