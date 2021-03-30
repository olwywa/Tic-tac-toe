package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame("Tic Tac Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new Board());
        window.setBounds(400,400,400,400);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }
}
