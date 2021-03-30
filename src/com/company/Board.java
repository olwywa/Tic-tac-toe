package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Board extends JPanel {

    JButton[] buttons = new JButton[9];
    Engine engine = null;

    public Board() {
        setLayout(new GridLayout(3, 3));
        engine = new Engine(this);
        initializeButtons();
    }

    public JButton[] initializeButtons() {  //set the buttons with onclick action

        for (int i = 0; i <= 8; i++) {
            buttons[i] = new JButton();
            buttons[i].setText(" ");
            buttons[i].setBackground(Color.white);
            buttons[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton buttonClicked = (JButton) e.getSource(); //get the particular button that was clicked
                    buttonClicked.setText(String.valueOf(engine.getCurrentPlayer()));

                    if (engine.getCurrentPlayer() == 'X') {
                        engine.changeCurrentPlayer('O');
                        buttonClicked.setBackground(Color.LIGHT_GRAY);
                    } else {
                        engine.changeCurrentPlayer('X');
                        buttonClicked.setBackground(Color.ORANGE);
                    }
                    engine.displayResult();
                }
            });

            add(buttons[i]);
        }
        return buttons;
    }

    void resetBoard() {
        for (int i = 0; i <= 8; i++) {
            buttons[i].setText(" ");
            buttons[i].setBackground(Color.WHITE);
        }
    }
}
