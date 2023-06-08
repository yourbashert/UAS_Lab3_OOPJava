import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LoveCalculatorApp extends JFrame {
    private JTextField nameField1, nameField2, resultField;
    private JLabel nameLabel1, nameLabel2, resultLabel, backgroundImage;
    private JButton calculateButton;

    public LoveCalculatorApp() {
        // Setting up the frame
        setTitle("Kalkulator Cinta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        // Creating and positioning the components
        nameLabel1 = new JLabel("Nama Pertama:");
        nameLabel1.setBounds(50, 30, 100, 30);
        nameLabel1.setForeground(Color.WHITE);
        nameField1 = new JTextField();
        nameField1.setBounds(160, 30, 150, 30);

        nameLabel2 = new JLabel("Nama Kedua:");
        nameLabel2.setBounds(50, 70, 100, 30);
        nameLabel2.setForeground(Color.WHITE);
        nameField2 = new JTextField();
        nameField2.setBounds(160, 70, 150, 30);

        resultLabel = new JLabel("Persentase Cinta:");
        resultLabel.setBounds(50, 110, 100, 30);
        resultLabel.setForeground(Color.WHITE);
        resultField = new JTextField();
        resultField.setBounds(160, 110, 150, 30);
        resultField.setEditable(false);

        calculateButton = new JButton("Hitung");
        calculateButton.setBounds(160, 150, 100, 30);

        backgroundImage = new JLabel(new ImageIcon("D:\\Lab 3 PBO IKLC\\background.jpg"));
        backgroundImage.setBounds(0, 0, 400, 300);

        // Adding components to the frame
        add(nameLabel1);
        add(nameField1);
        add(nameLabel2);
        add(nameField2);
        add(resultLabel);
        add(resultField);
        add(calculateButton);
        add(backgroundImage);

        // Adding action listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateLovePercentage();
            }
        });
    }

    private void calculateLovePercentage() {
        String name1 = nameField1.getText().trim();
        String name2 = nameField2.getText().trim();

        if (!name1.isEmpty() && !name2.isEmpty()) {
            Random random = new Random();
            int lovePercentage = random.nextInt(101);
            resultField.setText(lovePercentage + "%");

            String message;

            if (lovePercentage >= 0 && lovePercentage <= 10) {
                message = "Hm, sepertinya Tidak Ditakdirkan";
            } else if (lovePercentage >= 11 && lovePercentage <= 30) {
                message = "Hanya teman saja";
            } else if (lovePercentage >= 31 && lovePercentage <= 60) {
                message = "Mungkin bisa lebih dari teman";
            } else if (lovePercentage >= 61 && lovePercentage <= 80) {
                message = "Gass aja, semoga kapal berlayar";
            } else {
                message = "Kalian memang ditakdirkan bersama";
            }

            JOptionPane.showMessageDialog(this, message);
        } else {
            JOptionPane.showMessageDialog(this, "Mohon masukkan nama kedua orang.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoveCalculatorApp app = new LoveCalculatorApp();
                app.setVisible(true);
            }
        });
    }
}
