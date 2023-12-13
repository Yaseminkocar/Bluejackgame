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
        int m = 0;
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < colour.length; j++) {
                for (int k = 1; k < sign.length; k++) {
                    deck[m] = new Card(number[i], colour[j], sign[0]);
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
            System.out.println("Player 1's cards are:" + player1[j]);

        }
        System.out.println("************************");
        for (int k = 0; k < 5; k++) {
            System.out.println("Player 2's cards are:" + player2[k]);
        }
        System.out.println("with sign cards:");
        Card[] deck1 = new Card[8];
        for (int i = 0; i < 3; i++) {
            int selectedNumber = number[rd.nextInt(1, 6)];
            String selectedColour = colour[rd.nextInt(colour.length)];
            int selectedSign = sign[rd.nextInt(sign.length)];
            Card randomCard = new Card(selectedNumber, selectedColour, selectedSign);

            //System.out.println(randomCard);
            for (int p = 0; p < 8; p++) {
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
            System.out.println("player1's cards:" + player1[f]);

        }
        System.out.println("******************");
        for (int g = 0; g < 8; g++) {
            System.out.println("player 2's cards:" + player2[g]);
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