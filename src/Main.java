import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        Card[] deck = new Card[40];
        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] colour = {"blue", "yellow", "red", "green"};
        int[] sign = {+1, -1};
        String[] special = {"dbl", "flip","."};
        int m = 0;
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < colour.length; j++) {
                for (int k = 1; k < sign.length; k++) {
                    deck[m] = new Card(number[i], colour[j], sign[0],special[2]);
                    m++;

                }
            }
        }
        Shuffle(deck);
        System.out.println("Here is shuffled deck.");
        printDeck(deck);


        System.out.println("**********************");
        Card player1[] = new Card[10];
        Card player2[] = new Card[10];
        for (int i = 0; i < 5; i++) {
            player1[i] = deck[i];
            player2[i] = deck[39 - i];
        }
        for (int j = 0; j < 5; j++) {
           // System.out.println("Player 1's cards are:" + player1[j]);

        }
        //System.out.println("************************");
        for (int k = 0; k < 5; k++) {
          //  System.out.println("Player 2's cards are:" + player2[k]);
        }
        //System.out.println("with sign cards:");
        Card[] deck1 = new Card[10];
        for (int i = 0; i < 3; i++) {
            for (int p = 0; p < 10; p++) {
            int selectedNumber = number[rd.nextInt(1, 6)];
            String selectedColour = colour[rd.nextInt(colour.length)];
            int selectedSign = sign[rd.nextInt(sign.length)];

                Card randomCard = new Card(selectedNumber, selectedColour, selectedSign,special[2]);
                //System.out.println(randomCard);
                deck1[p] = randomCard;
            }
        }

        for (int k = 0; k < 3; k++) {
            player1[5 + k] = deck1[k];
        }
        for (int s = 0; s < 3; s++) {
            player2[5 + s] = deck1[3 + s];
        }
        for (int f = 0; f < 8; f++) {
           // System.out.println("player1's cards:" + player1[f]);

        }
       // System.out.println("******************");
        for (int g = 0; g < 8; g++) {
          //  System.out.println("player 2's cards:" + player2[g]);
        }
        //String[] special = {"dbl", "flip","."};
        int k = rd.nextInt(1, 11);
        if (k > 0 && k < 9) {
            for (int i = 8; i < 10; i++) {
                int t=rd.nextInt(0,10);
                player1[i] = deck1[t];
                int p=rd.nextInt(0,10);
                player2[i] = deck1[p];
            }
        } else if (k >= 9 && k <= 10) {
            int a = rd.nextInt(0, 2);
            for (int j = 8; j < 10; j++) {
                player1[j] =new Card(0,null,0,special[a]);
                int b=rd.nextInt(0,2);
                (player2[j]) =new Card(0,null,0,special[b]);

            }
        }
        for (int b = 0; b < 10; b++) {
            System.out.println("player1's cards are: " + player1[b]);
        }
        System.out.println("*********************");
        for (int c = 0; c < 10; c++) {
            System.out.println(("player2's cards are: " + player2[c]));
        }

        System.out.println("player1's hand:");
        for (int i = 0; i < 4; i++) {
            int randomInd = rd.nextInt(player1.length);
           // System.out.println("Card " + (i + 1) + ": " + player1[randomInd]);
        }
        System.out.println("X,X,X,X");// We cannot see computer's hand.
        System.out.println("*********************");

        System.out.println("Player2's hand:");
        for (int i = 0; i < 4; i++) {
            int randomInd2 = rd.nextInt(player2.length);
            System.out.println("Card " + (i + 1) + ": " + player2[randomInd2]);
        }
    }


    public static void Shuffle(Card[] deck) {
        Random rd = new Random();
        for (int i = 0; i < 40; i++) {
            int j = rd.nextInt(40);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public static void printDeck(Card[] deck) {
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}
