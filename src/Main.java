import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame rootPanel = new JFrame("Manager Spitale");
        rootPanel.setContentPane(new FormIntrare().root);
        rootPanel.setSize(600,400);
        rootPanel.setVisible(true);
        rootPanel.setLocationRelativeTo(null);
       // final JList list = new JList(listElems);
        rootPanel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
