import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Counter {

  private JFrame frame;
  private JLabel countLabel;
  private JButton incrementButton, decrementButton;
  private int counter = 0;

  public Counter() {
    frame = new JFrame("Counter");
    frame.setLayout(null);
    frame.setSize(300, 150);

    countLabel = new JLabel(String.valueOf(counter));
    countLabel.setBounds(100, 30, 100, 50);
    countLabel.setFont(countLabel.getFont().deriveFont(30f));
    frame.add(countLabel);

    incrementButton = new JButton("Increment");
    incrementButton.setBounds(50, 90, 100, 30);
    incrementButton.addActionListener(new ButtonListener());
    frame.add(incrementButton);

    decrementButton = new JButton("Decrement");
    decrementButton.setBounds(150, 90, 100, 30);
    decrementButton.addActionListener(new ButtonListener());
    frame.add(decrementButton);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  private class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      String buttonText = e.getActionCommand();

      if (buttonText.equals("Increment")) {
        counter++;
      } else if (buttonText.equals("Decrement") && counter > 0) {
        counter--;
      }

      countLabel.setText(String.valueOf(counter));
    }
  }

  public static void main(String[] args) {
    new Counter();
  }
}
