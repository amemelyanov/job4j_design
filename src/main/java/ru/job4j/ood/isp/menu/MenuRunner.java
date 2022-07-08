package ru.job4j.ood.isp.menu;

public class MenuRunner {

    public void run(Node menu, Output out, Input in, Get get) {
        boolean run = true;
        while (run) {
            out.show(menu);
            String number =  in.askStr("PLease enter number of menu item in format X.X.X. or EXIT:"
                    + System.lineSeparator());
            if (number.equalsIgnoreCase("exit")) {
                run = false;
            } else {
                Node current = get.getNode(menu, number);
                if (current == null) {
                    System.out.println("Please enter correct number of menu");
                } else {
                    current.getAction().execute();
                }
                System.out.println("====================================");
            }
        }
    }

    public static void main(String[] args) {
        MenuRunner runner = new MenuRunner();
        Output out = new ConsoleOutput();
        Input in = new ConsoleInput();
        Get getMenu = new GetMenuItem();
        Node menu = new Menu("0.", "Меню", new MenuAction("Выполнить Меню"));
        Node one = new Menu("1.", "Задача", new MenuAction("Выполняется задача 1."));
        Node oneOne = new Menu("1.1.", "Задача", new MenuAction("Выполняется задача 1.1."));
        Node oneOneOne = new Menu("1.1.1.", "Задача", new MenuAction("Выполняется задача 1.1.1."));
        Node oneOneTwo = new Menu("1.1.2.", "Задача", new MenuAction("Выполняется задача 1.1.2."));
        Node oneTwo = new Menu("1.2.", "Задача", new MenuAction("Выполняется задача 1.2."));
        menu.addChild(one);
        one.addChild(oneOne);
        one.addChild(oneTwo);
        oneOne.addChild(oneOneOne);
        oneOne.addChild(oneOneTwo);

        runner.run(menu, out, in, getMenu);
    }
}
