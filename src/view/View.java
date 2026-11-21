package view;

import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class View {
  private static final String title = "Sistema de Biblioteca Universitária";

  private static final int dimension  = (Toolkit.getDefaultToolkit().getScreenSize()).height >> 1;

  private JFrame frame;

  public View() {
    frame = new JFrame();

    frame.setTitle(title);
    frame.setSize(dimension, dimension);
    frame.setLocationRelativeTo(null);
    frame.setLayout(new GridBagLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel columnPanel = new JPanel();
    columnPanel.setLayout(new BoxLayout(columnPanel, BoxLayout.Y_AXIS));

    JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JLabel titleLabel = new JLabel("Sistema de Biblioteca Universitária");
    titlePanel.add(titleLabel);
    
    JTextField cpfText = new JTextField(15);

    JPanel cpfPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    cpfPanel.add(new JLabel("CPF"));
    cpfPanel.add(cpfText);

    JPasswordField senhaText = new JPasswordField(15);

    JPanel senhaPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    senhaPanel.add(new JLabel("Senha"));
    senhaPanel.add(senhaText);

    JButton entrarButton = new JButton("Entrar");

    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.add(entrarButton);

    columnPanel.add(titlePanel);
    columnPanel.add(cpfPanel);
    columnPanel.add(senhaPanel);
    columnPanel.add(buttonPanel);

    frame.add(columnPanel);

    frame.setVisible(true);
  }

  public String getTitle() {
    return title;
  }

  public int getWidth() {
    return dimension;
  }
}
