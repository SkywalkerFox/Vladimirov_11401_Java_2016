import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameFrame extends JFrame {
    private int buttonSize = 50;
    private final int SIZE = 5;
    private JFrame inputFrame = null;
    private JToggleButton[][] buttons;
    private String word = "";
    private boolean player1Move = true;
    private ArrayList<String> dictionary = new ArrayList<String>();
    private int player1Points;
    private int player2Points;

    public GameFrame() throws FileNotFoundException {
        Scanner words = new Scanner(new File("C:\\Users\\Павел\\Desktop\\Game\\src\\word_rus.txt"));
        while (words.hasNextLine()) {
            dictionary.add(words.nextLine().toUpperCase());
        }

        player1Points = 0;
        player2Points = 0;

        buttons = new JToggleButton[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new JToggleButton();

                buttons[i][j].setBounds(j * buttonSize, i * buttonSize, buttonSize, buttonSize);

                System.out.println(buttons[i][j].getBounds());
                if (i == 2) {
                    if (j == 0) {
                        buttons[i][j].setText("Б");
                    }
                    if (j == 1) {
                        buttons[i][j].setText("А");
                    }
                    if (j == 2) {
                        buttons[i][j].setText("Л");
                    }
                    if (j == 3) {
                        buttons[i][j].setText("Д");
                    }
                    if (j == 4) {
                        buttons[i][j].setText("А");
                    }

                }

                final int finalI = i;
                final int finalJ = j;
                buttons[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //if (areLettersNear(finalI, finalJ)) {
                        if (buttons[finalI][finalJ].getText().equals("")) {
                            Pattern pattern = Pattern.compile("[а-яА-Я]");

                            String answer = JOptionPane.showInputDialog(inputFrame,
                                    "Введите букву",
                                    "Новая буква", JOptionPane.INFORMATION_MESSAGE);
                            Matcher matcher = pattern.matcher(answer);
                            System.out.println(matcher.matches());
                            while (!matcher.matches()) {
                                answer = JOptionPane.showInputDialog(inputFrame,
                                        "Введите одну букву русского алфавита",
                                        "Новая буква", JOptionPane.ERROR_MESSAGE);
                                matcher = pattern.matcher(answer);
                                System.out.println(matcher.matches());
                            }
                            buttons[finalI][finalJ].setText(answer.toUpperCase());
                            word += buttons[finalI][finalJ].getText();

                        } else {
                            if (!buttons[finalI][finalJ].isSelected()) {
                                word = word.substring(0, word.length() - 1);
                            } else {
                                word += buttons[finalI][finalJ].getText();
                            }

                        }
                        System.out.println(word);
                        /*} else {
                            JOptionPane.showMessageDialog(inputFrame,
                                    "sdfsdf",
                                    "sdfs", JOptionPane.ERROR_MESSAGE);
                        }*/
                    }


                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });

                add(buttons[i][j]);
                System.out.println(buttons[i][j].getText());
            }

        }



        final JLabel player1Label = new JLabel("Player 1:");
        player1Label.setForeground(Color.RED);
        player1Label.setBounds(0, 6 * buttonSize, 2 * buttonSize, buttonSize);
        add(player1Label);
        JLabel player2Label = new JLabel("Player 2:");
        player2Label.setForeground(Color.BLUE);
        player2Label.setBounds(3 * buttonSize, 6 * buttonSize, 2 * buttonSize, buttonSize);
        add(player2Label);

        final JPanel panel1 = new JPanel();
        final JScrollPane player1Words = new JScrollPane(panel1);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        player1Words.setBounds(0, 7 * buttonSize, 2 * buttonSize, buttonSize);
        player1Words.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        player1Words.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(player1Words);;

        final JPanel panel2 = new JPanel();
        final JScrollPane player2Words = new JScrollPane(panel2);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        player2Words.setBounds(3 * buttonSize, 7 * buttonSize, 2 * buttonSize, buttonSize);
        player2Words.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        player2Words.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(player2Words);

        JButton makeMoveButton = new JButton("Сделать ход");
        makeMoveButton.setBounds(0, 5 * buttonSize, 3 * buttonSize, buttonSize);
        makeMoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dictionary.contains(word)) {
                    JLabel playerWord = new JLabel(word + " " + word.length());
                    playerWord.setAlignmentX(JLabel.LEFT_ALIGNMENT);
                    if (player1Move) {
                        panel1.add(playerWord);
                        player1Words.revalidate();
                        player1Points += word.length();
                    } else {
                        panel2.add(playerWord);
                        player2Words.revalidate();
                        player2Points += word.length();
                    }
                    dictionary.remove(word);
                    word = "";
                    disableSelectedButtons();
                } else {
                    if (dictionary.contains(flipWord(word))) {
                        JLabel playerWord = new JLabel(word + " " + word.length());
                        playerWord.setAlignmentX(JLabel.LEFT_ALIGNMENT);
                        if (player1Move) {
                            panel1.add(playerWord);
                            player1Words.revalidate();
                            player1Points += word.length();
                        } else {
                            panel2.add(playerWord);
                            player2Words.revalidate();
                            player2Points += word.length();
                        }
                        dictionary.remove(word);
                        word = "";
                        disableSelectedButtons();
                    } else {
                        JOptionPane.showMessageDialog(inputFrame,
                                "Такого слова нет в словаре",
                                "Ошибка", JOptionPane.WARNING_MESSAGE);
                    }
                }
                player1Move = !player1Move;
            }
        });
        add(makeMoveButton);

        JButton endGameButton = new JButton("Конец");
        endGameButton.setBounds(3 * buttonSize, 5 * buttonSize, 2 * buttonSize, buttonSize);
        endGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    endGame();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        add(endGameButton);

        setBounds(50, 50, buttonSize * SIZE + 16, buttonSize * SIZE + 250);
        setLayout(new GroupLayout(getContentPane()));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /*public boolean areLettersNear(int x, int y) {
        return !(buttons[x + 1][y].getText().equals("") && buttons[x - 1][y].getText().equals("") && buttons[x][y + 1].getText().equals("") &&
                buttons[x][y - 1].getText().equals(""));
    }*/

    public void disableSelectedButtons() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j].isSelected()) {
                    buttons[i][j].setSelected(false);
                }
            }
        }
    }

    public void endGame() throws FileNotFoundException {
        if (player1Points > player2Points) {
            JOptionPane.showMessageDialog(inputFrame,
                    "Победил игрок 1!(" + player1Points + " против " + player2Points + ")",
                    "Конец игры",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (player2Points > player1Points) {
                JOptionPane.showMessageDialog(inputFrame,
                        "Победил игрок 2!(" + player2Points + " против " + player1Points + ")",
                        "Конец игры",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(inputFrame,
                        "Победила дружба!",
                        "Конец игры",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
        new GameFrame();

    }

    public String flipWord(String word) {
        return new StringBuffer(word).reverse().toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new GameFrame();
    }

}
