import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Card {
    private String suit; 
    private String rank; 

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }
    public String getRank() {
        return rank;
    }
    @Override
    public String toString() {
        return rank + " " + suit;
    }
}

class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }

    private void initializeDeck() {
        String[] suits = {"Bich", "Chuồn", "Rô", "Cơ"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {    
        if (cards.isEmpty()) {
            return null; 

        }
        return cards.remove(cards.size() - 1); 
    }
}  
class Player {
    private String name;
    private List<Card> hand;
 
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void drawCard(Card card) {
        hand.add(card);
    }
    public void showHand() {
        System.out.println(name + "'s hand:");
        for (Card card : hand) {
            System.out.println(card);
        }
    }
    public int getTotalPoint() {
        int totalPoint = 0;
        for (Card card : hand) {
            totalPoint += getValuePoint(card);
        }
        int finalPoint = totalPoint % 10;
        System.out.println("Tổng điểm của " + name + " là: " + finalPoint);
        return finalPoint;
    }
    public int getValuePoint (Card card) {
      
            if (card.getRank().equals("A")) {
               return  1;
            } else if (card.getRank().equals("J") || card.getRank().equals("Q") || card.getRank().equals("K")) {
                return   10;
            } else {
                return Integer.parseInt(card.getRank());
            }
     
    }
    
}

public class main {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng người chơi: ");
        int numPlayers = scanner.nextInt();
        Deck deck = new Deck();
        Player[] players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new Player("Player " + (i + 1));
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < numPlayers; j++) {
                Card card = deck.dealCard();
                if (card == null) break; 
                players[j].drawCard(card);
            }
        }
        int maxPoints = Integer.MIN_VALUE;
        Player winner = null;
        for (Player player : players) {
            player.showHand();
            int totalPoints = player.getTotalPoint();
            if (totalPoints > maxPoints) {
                maxPoints = totalPoints;
                winner = player;

            }
        }
        
        if (winner != null) {
            System.out.println("Người chiến thắng là: " + winner.getName() + " với " + maxPoints + " điểm!");
        }


        scanner.close();
    
    }
}
