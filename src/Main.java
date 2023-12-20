import java.sql.SQLOutput;
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
        String[] special = {"dbl", "flip", ""};
        int m = 0;
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < colour.length; j++) {
                for (int k = 1; k < sign.length; k++) {
                    deck[m] = new Card(number[i], colour[j], sign[0], special[2]);
                    m++;

                }
            }
        }
        Shuffle(deck);
        System.out.println("WELCOME TO THE BLUEJACK GAME");
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

                Card randomCard = new Card(selectedNumber, selectedColour, selectedSign, special[2]);
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
            // for (int i = 8; i < 10; i++) {
            int t = rd.nextInt(0, 10);
            int s = rd.nextInt(0, 10);
            player1[8] = deck1[t];
            player1[9] = deck1[s];
            int p = rd.nextInt(0, 10);
            int r = rd.nextInt(0, 10);
            if (t != p) {
                player2[8] = deck1[p];
                player2[9] = deck1[r];
            } else {
                int c = rd.nextInt(0, 10);
                int y = rd.nextInt(0, 10);
                player2[8] = deck1[c];
                player2[9] = deck1[y];
            }

        } else if (k >= 9 && k <= 10) {
            int a = rd.nextInt(0, 2);
            for (int j = 8; j < 10; j++) {
                player1[j] = new Card(0, null, 0, special[a]);
                int b = rd.nextInt(0, 2);
                (player2[j]) = new Card(0, null, 0, special[b]);

            }
        }
        for (int b = 0; b < 10; b++) {
            System.out.println("player1's cards are: " + player1[b]);
        }
        System.out.println("*********************");
        for (int c = 0; c < 10; c++) {
            System.out.println(("player2's cards are: " + player2[c]));
        }
        System.out.println("***********************");
        Card[] hand1 = new Card[4];
        Card[] hand2 = new Card[4];
        Shuffleplayer(player1);
        Shuffleplayer(player2);
        /*for(int j=0;j<10;j++) {
            System.out.println(player1[j]);
        }
        System.out.println("*******************"); This part for seeing shuffled player arrays.
        for(int j=0;j<10;j++) {
            System.out.println(player2[j]);
        }*/
        for (int i = 0; i < 4; i++) {
            hand1[i] = player1[i];
            //System.out.println("Card " + (i + 1) + ": " + player1[i]);
        }
        for (int i = 0; i < 4; i++) {
            hand2[i] = player2[i];
            //System.out.println("Card " + (i + 1) + ": " + player2[i]);
        }
        System.out.println("player1's hand:");
        for (int a = 0; a < 4; a++) {
            // System.out.println("Card " + (a + 1) + ": " +hand1[a]);
        }
        System.out.println("X,X,X,X");// We cannot see computer's hand.
        System.out.println("*****************");
        System.out.println("Player2's hand:");
        for (int b = 0; b < 4; b++) {
            System.out.println("Card " + (b + 1) + ": " + hand2[b]);
        }
        System.out.println("GAME BEGAN");
        int cpoint = 0;
        int ppoint = 0;
        int comppoint = 0;
        int playerpoint = 0;
        while (comppoint < 3 && playerpoint < 3) {
            Card[] board1 = new Card[9];
            Card[] board2 = new Card[9];
            while (getScore(board1) < 17 && getScore2(board2) < 17) {
                int a = rd.nextInt(10, 29);

                board1[0] = deck[a];//I gave a random card from deck to comp.
                deck[a] = null;
                int b = rd.nextInt(10, 29);
                if (a != b) {
                    if (deck[b] != null) {
                        board2[0] = deck[b];
                        deck[b] = null;
                    } else if (deck[b] == null) {
                        int v = rd.nextInt(10, 29);
                        board2[0] = deck[v];
                    } if(getScore(board2)>20) {
                        System.out.println("BUST");
                        System.out.println(board2[1]);
                        for (int i = 0; i < hand2.length; i++) {
                            if (hand2[i] != null) {
                                if (hand2[i].getSpecial().equals("flip")) {
                                    System.out.println("please make move.");
                                    int move = sc.nextInt();
                                    board2[5] = hand2[move];
                                    hand2[move] = null;
                                    int c = board2[3].getNumber() * -1;
                                    board2[3] = board2[c];
                                    getScore2(board2);
                                }
                            }
                        }
                    }
                } else {
                    int c = rd.nextInt(10, 29);
                    if (deck[c] != null) {
                        board2[0] = deck[c];
                    }
                    deck[c] = null;

                }
               /*if(getScore2(board2)>20){
                    System.out.println("If you have a save card please enter card number.");
                    //A save card saves you from getting 20.
                    int x=sc.nextInt();
                    board2[1]=hand2[x];

                }*/


                System.out.println("computer's board is:" + board1[0]);
                System.out.println("player's board is:" + board2[0]);
                System.out.println("Your score is:");
                System.out.println(getScore2(board2));
                System.out.println("if you want another card please enter 1.");
                System.out.println("if you want to stand please enter 2.");
                int choice = sc.nextInt();
                if (choice == 1) {

                    int t = rd.nextInt(10, 29);
                    if (deck[t] != null) {
                        board1[1] = deck[t];
                    } else if (deck[t] == null) {
                        int r = rd.nextInt(10, 29);
                        board1[1] = deck[r];
                        deck[r] = null;
                    }


                    int p = rd.nextInt(10, 29);
                    if (deck[p] != null) {
                        board2[1] = deck[p];
                    } else if (deck[p] == null) {
                        int y = rd.nextInt(10, 29);
                        board2[1] = deck[y];
                        deck[y] = null;
                    } else {
                        int y = rd.nextInt(10, 29);
                        if (deck[y] != null) {
                            board2[1] = deck[y];
                            deck[y] = null;
                        }
                    }
                    if(getScore(board2)>20) {
                        System.out.println("BUST");
                        System.out.println(board2[1]);
                        for (int i = 0; i < hand2.length; i++) {
                            if (hand2[i] != null) {
                                if (hand2[i].getSpecial().equals("flip")) {
                                    System.out.println("please make move.");
                                    int move = sc.nextInt();
                                    board2[5] = hand2[move];
                                    hand2[move] = null;
                                    int c = board2[1].getNumber() * -1;
                                    board2[1] = board2[c];
                                    getScore2(board2);
                                }
                            }
                        }
                    }
                } else if (choice == 2) {
                    System.out.println("waiting for the computer");
                    int t = getScore(board1);
                    int y = getScore2(board2);

                    int p = rd.nextInt(10, 29);
                    if (deck[p] != null) {
                        board1[1] = deck[p];
                    } else if (deck[p] == null) {
                        int s = rd.nextInt(10, 29);
                        board1[1] = deck[s];
                        deck[s] = null;
                    }


                    if (t > y) {
                        System.out.println("computer wins");

                        break;
                    } else if (t < y) {
                        System.out.println("you win!!!!!!");
                        break;
                    } else if (t == y) {
                        System.out.println("1-1");
                    }
                    break;
                }

                System.out.println("computer's board is:" + board1[1]);
                System.out.println("player's board is:" + board2[1]);
                System.out.println("your score is:");
                System.out.println(getScore2(board2));
                System.out.println("if you want another card please enter 1.");
                System.out.println("if you want to stand please enter 2.");
                int choice2 = sc.nextInt();
                if (choice2 == 1) {
                    int t = rd.nextInt(10, 29);
                    if (deck[t] != null) {
                        board1[2] = deck[t];
                    } else if (deck[t] == null) {
                        board1[2] = deck[t + 1];
                        deck[t + 1] = null;
                    }

                    int g = rd.nextInt(10, 29);
                    if (deck[g] != null) {
                        board2[2] = deck[g];
                    } else if (deck[g] == null) {
                        int c = rd.nextInt(10, 29);
                        board2[2] = deck[c];
                        deck[c] = null;
                    }
                    if(getScore(board2)>20) {
                        System.out.println("BUST");
                        System.out.println(board2[1]);
                        for (int i = 0; i < hand2.length; i++) {
                            if (hand2[i] != null) {
                                if (hand2[i].getSpecial().equals("flip")) {
                                    System.out.println("please make move.");
                                    int move = sc.nextInt();
                                    board2[5] = hand2[move];
                                    hand2[move] = null;
                                    int c = board2[2].getNumber() * -1;
                                    board2[2] = board2[c];
                                    getScore2(board2);
                                }
                            }
                        }
                    }
                } else if (choice2 == 2) {
                    System.out.println("waiting for the computer");
                    int p = getScore(board1);
                    int h = getScore2(board2);
                    if (p > h) {
                        System.out.println("computer wins");

                        break;
                    } else if (p < h) {
                        System.out.println("you win!!!!!!");

                        break;
                    } else if (p == h) {
                        System.out.println("1-1");
                    }
                    break;
                }

          /* if(getScore(board1)>20||getScore2(board2)>20){
                System.out.println("BUST");
                System.out.println(board1[2]);
                System.out.println(board2[2]);
            }*/

                System.out.println("computer's board is:" + board1[2]);
                System.out.println("player's board is:" + board2[2]);
                System.out.println("Your score is:");
                System.out.println(getScore2(board2));
                System.out.println("if you want another card please enter 1.");
                System.out.println("if you want to stand please enter 2.");
                int choice3 = sc.nextInt();
                if (choice3 == 1) {
                    int e = rd.nextInt(10, 29);
                    if (deck[e] != null) {
                        board1[3] = deck[e];
                    } else if (deck[e] == null) {
                        int t = rd.nextInt(10, 29);
                        board1[3] = deck[t];
                        deck[t] = null;
                    }


                    int f = rd.nextInt(10, 29);
                    if (e != f) {
                        if (deck[f] != null) {
                            board2[3] = deck[f];
                        } else if (deck[f] == null) {
                            int u = rd.nextInt(10, 29);
                            board2[3] = deck[u];
                            deck[u] = null;

                        } else {
                            int h = rd.nextInt(10, 29);
                            if (deck[h] != null) {
                                board2[3] = deck[h];
                            } else if (deck[h] == null) {
                                int r = rd.nextInt(10, 29);
                                board2[3] = deck[r];
                                deck[r] = null;
                            }
                        }
                    }
                } else if (choice3 == 2) {
                    System.out.println("waiting for the computer");
                    int t = getScore(board1);
                    int y = getScore2(board2);
                    if (t > y) {
                        System.out.println("computer wins");

                        break;
                    } else if (t < y) {
                        System.out.println("you win!!!!!!");

                        break;
                    } else if (t == y) {
                        System.out.println("1-1");
                    }

                    /*if (getScore(board1) > 20 || getScore2(board2) > 20) {
                        System.out.println("BUST");
                        System.out.println(board1[3]);
                        System.out.println(board2[3]);
                    }*/
                }
                System.out.println("computer's board is:" + board1[3]);
                System.out.println("player's board is:" + board2[3]);
                System.out.println("Your score is:");
                System.out.println(getScore2(board2));
                System.out.println("*****************");
                System.out.println(getScore(board1));
                System.out.println(getScore2(board2));
                if (getScore(board1) == 20) {
                    System.out.println("Computer wins the tour.");
                } else if (getScore2(board2) == 20) {
                    System.out.println("You win the tour.");
                }

                //System.out.println("computer's board is:" + board1[3]);
                //System.out.println("player's board is:" + board2[3]);
                // getScore(board1);
                // getScore2(board2);

                if (comppoint > playerpoint) {
                    System.out.println("Computer wins!!!!!!!!!!!!!!!");
                } else if (playerpoint > comppoint) {
                    System.out.println("You win!!!!!!!!!!!!!!!");
                }
                break;
            }
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
    public static void Shuffleplayer(Card[] deck) {
        Random rd = new Random();
        for (int i = 0; i < 10; i++) {
            int j = rd.nextInt(10);
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
    public static int getScore(Card[] board1) {
        int sum = 0;
        for (Card c : board1) {
            if (c != null) {
                sum += c.getNumber();

            }
        }
        //System.out.println(sum);
        return sum;
    }
    public static int getScore2(Card[] board2) {
        int sum2 = 0;
        for (Card c : board2) {
            if (c != null) {
                sum2 += c.getNumber();
            }
        }
       // System.out.println(sum2);
        return sum2;
    }
}

