import ui.*;
import javax.swing.*;
import java.awt.*;

public class Main {

  public static void main(String[] args) {
    JFrame frame = new JFrame("Milk Tea Order");
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Header header = new Header();
    Option options = new Option();
    frame.add(header.getPanel(), BorderLayout.NORTH);
    frame.add(options.getPanel(), BorderLayout.CENTER);
    frame.setVisible(true);
  }
}
