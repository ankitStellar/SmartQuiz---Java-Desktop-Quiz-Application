import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class QuizApp extends JFrame implements ActionListener {
    JLabel questionLabel;
    JRadioButton[] options = new JRadioButton[3];
    ButtonGroup bg = new ButtonGroup();
    JButton nextButton;
    Connection conn;
    ResultSet rs;
    int score = 0;

    public QuizApp() {
        conn = DBConnection.connect();
        setLayout(new GridLayout(5, 1));

        questionLabel = new JLabel();
        add(questionLabel);

        for (int i = 0; i < 3; i++) {
            options[i] = new JRadioButton();
            bg.add(options[i]);
            add(options[i]);
        }

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        add(nextButton);

        setTitle("Quiz App");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        loadNextQuestion();
    }

    void loadNextQuestion() {
        try {
            if (rs == null) {
                Statement stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM questions");
            }

            if (rs.next()) {
                questionLabel.setText(rs.getString("question"));
                options[0].setText(rs.getString("optionA"));
                options[1].setText(rs.getString("optionB"));
                options[2].setText(rs.getString("optionC"));
            } else {
                JOptionPane.showMessageDialog(this, "Quiz Over! Your score: " + score);
                System.exit(0);
            }

            bg.clearSelection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String selected = "";
            for (JRadioButton rb : options) {
                if (rb.isSelected()) {
                    selected = rb.getText();
                    break;
                }
            }

            if (selected.equals(rs.getString("correct"))) {
                score++;
            }

            loadNextQuestion();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new QuizApp();
    }
}
