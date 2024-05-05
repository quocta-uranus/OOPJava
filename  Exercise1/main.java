import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Card {
    private String suit; 
    private String rank; 

     Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

     String getSuit() {
        return suit;
    }
    String getRank() {
        return rank;
    }
    @Override
    public String toString() {
        return rank + " " + suit;
    }
    
}

class Deck {
    private List<Card> cards;

     Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }

    private void initializeDeck() {
        String[] suits = {"Bich", "Chuon", "Ro", "Co"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    void shuffle() {
        Collections.shuffle(cards);
    }

    Card dealCard() {    
        if (cards.isEmpty()) {
            return null; 

        }
        return cards.remove(cards.size() - 1); 
    }
     int size() {
        return cards.size();
    }
    
}  
class Player {
    private String name;
    private List<Card> hand;
    
     Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    String getName() {
        return name;
    }
     void drawCard(Card card) {
        hand.add(card);
    }
    void showHand() {
        System.out.println(name + "'s hand:");
        for (Card card : hand) {
            System.out.println(card);
        }
    }
    
    int getTotalPoint() {
        int totalPoint = 0;
        for (Card card : hand) {
            totalPoint += getValuePoint(card);
        }
        
        return totalPoint;
      
    }
    
    int getFinalPoint() {
        int totalPoint = 0;
        for (Card card : hand) {
            totalPoint += getValuePoint(card);
        }
        int finalPoint = totalPoint % 10;
        return finalPoint;
      
    }
    void showFinalPoint () {
        
        int Point = getFinalPoint();
        
        System.out.println("Tong diem cua " + name + " la: " + Point);
        
    }
    
    
   

    int getValuePoint (Card card) {
      
            if (card.getRank().equals("A")) {
               return  41;
            } else if (card.getRank().equals("J") ) {
                return   20;
            }
            else if( card.getRank().equals("Q")) {
                return 30 ;
            } 
            else if( card.getRank().equals("K")) {
                return 40;
            }
            else {
                return Integer.parseInt(card.getRank());
            }
     
    }
     String getHighestCardSuit() {
        if (hand.isEmpty()) {
            return null; 
        }
    
        Card highestCard = hand.get(0); 
        for (Card card : hand) {
            if (getValuePoint(card) > getValuePoint(highestCard)) {
                highestCard = card; 
            }
        }
    
        return highestCard.getSuit();
    }
    
    int getRankSuitValue(String suit) {
        switch (suit) {
            case "Co":
                return 4;
            case "Ro":
                return 3;
            case "Chuon":
                return 2;
            case "Bich":
                return 1;
            default:
                return 0; 
        }
    }
}

public class main {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong nguoi choi: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();
        Deck deck = new Deck();
        Player[] players = new Player[numPlayers];
        if (numPlayers * 3 > deck.size()) {
            System.out.println(" Error : So luong la bai khong du chia cho tat ca nguoi choi.");
            scanner.close();
            return;
        }
        String[] playerNames = new String[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Nhap ten cua nguoi choi " + (i + 1) + ": ");
            playerNames[i] = scanner.nextLine();
            players[i] = new Player(playerNames[i]);
        }

        dealCards(players, deck);

        Player winner = findTheWinner(players);
        if (winner != null) {
            int point = winner.getFinalPoint();
            System.out.println("Nguoi chien thang la: " + winner.getName() + " voi " + point + " diem!");
        }
        scanner.close();
    }

    public static void dealCards(Player[] players, Deck deck) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < players.length; j++) {
                Card card = deck.dealCard();
                if (card == null) break;
                players[j].drawCard(card);
            }
        }
    }

   public static Player findTheWinner(Player[] players) {
    int maxPoints = 0;
    Player winner = null;
    for (Player player : players) {
        player.showHand();
        player.showFinalPoint();
        int finalPoints = player.getFinalPoint();
       
        if (finalPoints >= maxPoints) {
            if (finalPoints > maxPoints || player.getTotalPoint() > winner.getTotalPoint() ||
                    (finalPoints == maxPoints && player.getTotalPoint() == winner.getTotalPoint() &&
                            player.getRankSuitValue(player.getHighestCardSuit()) > winner.getRankSuitValue(winner.getHighestCardSuit()))) {
                maxPoints = finalPoints;
                winner = player;
            }
        }
    }
    
    return winner;
}


      
}
