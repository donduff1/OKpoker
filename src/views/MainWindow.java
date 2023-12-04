/*
* File: MainWindow.java
* Author: Decker Borisz
* Copyright: 2023, Decker Borisz
* Date: 2023-11-29
* Licenc: MIT
*
*/
package views;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
    public JButton startBtn = new JButton("Start");
    public JButton stopBtn = new JButton("Stop");
    public JButton nextBtn = new JButton("Következő");
    
    public JPanel tablePanel = new JPanel();
    public JButton flop1Btn = new JButton("");
    public JButton flop2Btn = new JButton("");
    public JButton flop3Btn = new JButton("");
    public JButton turnButton = new JButton();
    public JButton riverButton = new JButton();
    
    public JPanel handPanel = new JPanel();
    public JButton humanCard1Btn = new JButton();
    public JButton humanCard2Btn = new JButton();
    
    public MainWindow() {
        initializeComponents();
        configureLayout();
        configureFrame();
    }

    private void initializeComponents() {
        // Table panel
        tablePanel.setSize(100, 100);
        tablePanel.setBackground(Color.LIGHT_GRAY);
        tablePanel.add(flop1Btn);
        tablePanel.add(flop2Btn);
        tablePanel.add(flop3Btn);
        flop1Btn.setVisible(false);
        flop2Btn.setVisible(false);
        flop3Btn.setVisible(false);

        // Hand panel
        handPanel.add(humanCard1Btn);
        handPanel.add(humanCard2Btn);

        // Button panel
        buttonPanel.add(startBtn);
        buttonPanel.add(nextBtn);
        buttonPanel.add(stopBtn);

        // Add components to table panel
        tablePanel.add(turnButton);
        tablePanel.add(riverButton);
        turnButton.setVisible(false);
        riverButton.setVisible(false);
    }

    private void configureLayout() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        add(buttonPanel);
        add(tablePanel);
        add(handPanel);
    }

    private void configureFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
    }

    private JPanel buttonPanel = new JPanel();
}