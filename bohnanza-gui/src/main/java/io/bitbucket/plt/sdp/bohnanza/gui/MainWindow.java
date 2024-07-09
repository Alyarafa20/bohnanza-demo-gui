package io.bitbucket.plt.sdp.bohnanza.gui;

import Game_pkg.Game;
import Game_pkg.Game_components.Cards_pkg.Card;
import Game_pkg.Game_components.Cardfactory;
import Game_pkg.Game_components.Player;
import Game_pkg.Game_components.Deck;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainWindow extends JFrame {

    private JTextField playerNameField;
    private JButton createPlayerButton;
    private JTextArea playerInfoArea;

    private JTextField cardNameField;
    private JButton createCardButton;
    private JTextArea cardInfoArea;

    private JButton startGameButton;
    private Game game;
    private Deck deck;

    public MainWindow(int numFields) {
        // Initialize the game instance and deck
        game = Game.getInstance();
        deck = Deck.getInstance();
        game.setHighBohnExtension(true);

        // Initialize GUI components
        playerNameField = new JTextField(20);
        createPlayerButton = new JButton("Create Player");
        playerInfoArea = new JTextArea(5, 20);

        cardNameField = new JTextField(20);
        createCardButton = new JButton("Create Card");
        cardInfoArea = new JTextArea(5, 20);

        startGameButton = new JButton("Start Game");

        // Add components to the frame
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Player Name:"));
        panel.add(playerNameField);
        panel.add(createPlayerButton);
        panel.add(new JScrollPane(playerInfoArea));

        panel.add(new JLabel("Card Name:"));
        panel.add(cardNameField);
        panel.add(createCardButton);
        panel.add(new JScrollPane(cardInfoArea));

        panel.add(startGameButton); // Add the start game button to the GUI

        this.setContentPane(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // Add Event Listeners for the buttons
        createPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPlayer(numFields);
            }
        });

        createCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCard();
            }
        });

        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
    }

    private void createPlayer(int numFields) {
        String playerName = playerNameField.getText();
        Player player = new Player(playerName, game, numFields);
        game.get_Players(player);
        playerInfoArea.setText("Player Created:\nName: " + player.getName());
    }

    private void createCard() {
        String cardName = cardNameField.getText().trim();
        Card card = Cardfactory.createCard(cardName);

        if (card != null) {
            deck.drawCard(card);
            cardInfoArea.setText("Card Created:\nName: " + card.getName());
        } else {
            cardInfoArea.setText("Error: Card type not found or creation failed.");
        }
    }

    private void startGame() {
        game.initializePlayers(6); // Example with 6 players
        game.startGame();
        updatePlayerInfo();
    }

    private void updatePlayerInfo() {
        StringBuilder sb = new StringBuilder();
        List<Player> players = game.get_Players(null);
        for (Player player : players) {
            sb.append("Player: ").append(player.getName()).append("\n");
        }
        playerInfoArea.setText("Game Started!\n" + sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainWindow(2));
    }
}
