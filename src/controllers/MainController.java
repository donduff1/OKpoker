/*
 * File: MainController.java
 * Author: Decker Borisz
 * Copyright: 2023, Decker Borisz
 * Date: 2023-11-29
 * License: MIT
 */

package controllers;

import java.util.Random;
import views.MainWindow;

public class MainController {

    enum Round {
        PREFLOP,
        FLOP,
        TURN,
        RIVER,
        SHOW
    }

    private final MainWindow mainWindow;
    private final String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "B", "D", "K", "A"};
    private Round round = Round.PREFLOP;
    private final Random random = new Random();

    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        initEvent();
    }

    private void initEvent() {
        mainWindow.startBtn.addActionListener(event -> handleStartButton());
        mainWindow.stopBtn.addActionListener(event -> System.out.println("Állj"));
        mainWindow.nextBtn.addActionListener(event -> handleNextButton());
    }

    private void handleStartButton() {
        int hcard1 = random.nextInt(cards.length);
        int hcard2 = random.nextInt(cards.length);

        String humanCard1Str = cards[hcard1];
        String humanCard2Str = cards[hcard2];

        mainWindow.humanCard1Btn.setText(humanCard1Str);
        mainWindow.humanCard2Btn.setText(humanCard2Str);

        System.out.printf("%d %d\n", hcard1, hcard2);
    }

    private void handleNextButton() {
        switch (round) {
            case PREFLOP:
                handlePreflop();
                break;
            case FLOP:
                handleFlop();
                break;
            case TURN:
                handleTurn();
                break;
            case RIVER:
                handleRiver();
                break;
        }
    }

    private void handlePreflop() {
        int flop1 = getRandom();
        int flop2 = getRandom();
        int flop3 = getRandom();

        setFlopButtonsText(flop1, flop2, flop3);
        showFlopButtons();
        round = Round.FLOP;
    }

    private void handleFlop() {
        int turn = getRandom();
        mainWindow.turnButton.setText(cards[turn]);
        mainWindow.turnButton.setVisible(true);
        round = Round.TURN;
    }

    private void handleTurn() {
        int river = getRandom();
        mainWindow.riverButton.setText(cards[river]);
        mainWindow.riverButton.setVisible(true);
        round = Round.RIVER;
    }

    private void handleRiver() {
        // Handle additional logic for the river if needed
    }

    private void setFlopButtonsText(int flop1, int flop2, int flop3) {
        mainWindow.flop1Btn.setText("♦" + cards[flop1]);
        mainWindow.flop2Btn.setText(cards[flop2]);
        mainWindow.flop3Btn.setText(cards[flop3]);
    }

    private void showFlopButtons() {
        mainWindow.flop1Btn.setVisible(true);
        mainWindow.flop2Btn.setVisible(true);
        mainWindow.flop3Btn.setVisible(true);
    }

    private int getRandom() {
        return random.nextInt(cards.length);
    }
}