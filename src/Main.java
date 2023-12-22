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
        int comppoint = 0;
        int playerpoint = 0;
        while (comppoint < 3 && playerpoint < 3) {
            Card[] board1 = new Card[9];
            Card[] board2 = new Card[9];
             //while (getScore(board1) < 20 && getScore2(board2) < 20) {
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
                     }
                 }
                 System.out.println("computer's board is:" + board1[0]);
                 System.out.println("player's board is:" + board2[0]);
                 System.out.println("Computer's score is:");
                 System.out.println(getScore(board1));
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
                     }
                     for(int i=0;i<hand1.length;i++) {
                         if (hand1[i].getSpecial().equals("dbl")) {
                             if (hand1[i].getNumber() < 11) {
                             }
                         }
                         System.out.println("comp plays it's dbl card");
                         int c = board1[1].getNumber() * 2;
                         board1[1].setNumber(c);
                         System.out.println("Computer's new score is:");
                         System.out.println(getScore(board1));

                     }

                     for(int i=0;i<hand2.length;i++) {
                         if (hand2[i].getSpecial().equals("dbl")) {

                             System.out.println("ıf you want to play dbl please enter");
                             int x = sc.nextInt();
                             hand2[x] = null;
                             int f = board2[1].getNumber() * 2;
                             board2[1].setNumber(f);
                             System.out.println("Your new score is:");
                             System.out.println(getScore2(board2));
                         }

                     }
                     if (getScore(board1) == 20) {
                         System.out.println("Computer wins.");
                         comppoint++;
                     } else if (getScore2(board2) == 20) {
                         System.out.println("You win.");
                         playerpoint++;
                     }
                     if (getScore(board1) > 20) {
                         System.out.println("BUST FOR COMP");
                         System.out.println(board1[1]);
                         for (int i = 0; i < hand1.length; i++) {
                             if (hand1[i].getSign() == -1) {
                                 System.out.println("computer plays it's - card");
                                 // board1[5]=hand1[i];
                                 int h = board1[1].getNumber();
                                 h += hand1[i - 1].getNumber() * (-1);
                                 board1[1].setNumber(h);
                                 System.out.println("computer's new score is:");
                                 System.out.println(getScore(board1));
                                 if (getScore(board1) > 20 && getScore2(board2) < 20) {
                                     System.out.println("You win the tour.");
                                     System.out.println(getScore(board1));
                                     System.out.println(getScore2(board2));
                                     playerpoint++;
                                 }
                             }
                         }
                         for (int i = 0; i < hand1.length; i++) {
                             if (hand1[i] != null) {
                                 if (hand1[i].getSpecial().equals("flip")) {
                                     System.out.println("comp plays it's flip card");
                                     board1[1].setNumber(board1[1].getNumber() * (-1));
                                     System.out.println("computer's new score is:");
                                     System.out.println(getScore(board1));
                                     if (getScore(board1) > 20 && getScore2(board2) < 20) {
                                         System.out.println("You win the tour.");
                                         System.out.println(getScore(board1));
                                         System.out.println(getScore2(board2));
                                         playerpoint++;
                                     }

                                 }
                             }
                         }

                         if (getScore(board1) > getScore2(board2)) {
                             System.out.println("Computer wins the tour");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                             comppoint++;
                         } else if (getScore(board1) < getScore2(board2)) {
                             System.out.println("You win the tour.");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                             playerpoint++;
                         } else if (getScore(board1) == getScore2(board2)) {
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                             System.out.println("1-1");
                         }
                         for (int i = 0; i < hand1.length; i++) {
                             if (hand1[i].getSign() != -1) {
                                 System.out.println("waiting for the player.");
                                 if (getScore(board1) > getScore2(board2)) {
                                     System.out.println("Computer wins the tour");
                                     System.out.println(getScore(board1));
                                     System.out.println(getScore2(board2));
                                     comppoint++;
                                 } else if (getScore(board1) < getScore2(board2)) {
                                     System.out.println("You win the tour.");
                                     System.out.println(getScore(board1));
                                     System.out.println(getScore2(board2));
                                     playerpoint++;
                                 } else if (getScore(board1) == getScore2(board2)) {
                                     System.out.println("1-1");
                                     System.out.println(getScore(board1));
                                     System.out.println(getScore2(board2));
                                 }
                             }
                         }

                     }
                     if (getScore2(board2) > 20) {
                         System.out.println("BUST");
                         System.out.println(board2[1]);
                         System.out.println("If you have - card you can play.");
                         System.out.println("If you don't have - card please enter 5 to wait computer.");
                         int r = sc.nextInt();
                         board2[5] = hand2[r - 1];
                         board2[5].setNumber(hand2[r - 1].getNumber() * (-1));
                         System.out.println("Your new score is:");
                         System.out.println(getScore2(board2));
                         for (int i = 0; i < hand2.length; i++) {
                             if (hand2[i] != null) {
                                 if (hand2[i].getSpecial().equals("flip")) {
                                     System.out.println("please make move.");
                                     int move = sc.nextInt();
                                     hand2[move] = null;
                                     board2[1].setNumber(board2[1].getNumber() * (-1));
                                     System.out.println("Your new score is:");
                                     System.out.println(getScore2(board2));

                                 }
                             }
                         }
                         if (getScore(board1) < 20 && getScore2(board2) > 20) {
                             System.out.println("Computer wins the tour.");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                             comppoint++;
                         } else if (getScore(board1) > getScore2(board2)) {
                             System.out.println("Computer wins the tour");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                             comppoint++;
                         } else if (getScore(board1) < getScore2(board2)) {
                             System.out.println("You win the tour.");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                             playerpoint++;
                         } else if (getScore(board1) == getScore2(board2)) {
                             System.out.println("1-1");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                         }
                         if (r == 5) {
                             if (getScore(board1) < 20 && getScore(board1) > getScore2(board2)) {
                                 System.out.println("computer wins.");
                                 System.out.println(getScore(board1));
                                 System.out.println(getScore2(board2));
                                 comppoint++;
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
                         System.out.println("Computer's score is:");
                         System.out.println(getScore(board1));
                         System.out.println("your score is:");
                         System.out.println(getScore2(board2));
                         comppoint++;

                     } else if (t < y) {
                         System.out.println("you win!!!!!!");
                         System.out.println("Computer's score is:");
                         System.out.println(getScore(board1));
                         System.out.println("your score is:");
                         System.out.println(getScore2(board2));
                         playerpoint++;
                     } else if (t == y) {
                         System.out.println("1-1");
                         System.out.println("Computer's score is:");
                         System.out.println(getScore(board1));
                         System.out.println("your score is:");
                         System.out.println(getScore2(board2));
                     }

                 }

                 System.out.println("computer's board is:" + board1[1]);
                 System.out.println("player's board is:" + board2[1]);
                 System.out.println("Computer's score is:");
                 System.out.println(getScore(board1));
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
                     for(int i=0;i<hand1.length;i++) {
                         if (hand1[i].getSpecial().equals("dbl")) {
                             if (hand1[i].getNumber() < 11) {
                                 System.out.println("comp plays it's dbl card");
                             }
                         }
                         int c = board1[2].getNumber() * 2;
                         board1[2].setNumber(c);
                         System.out.println("Computer's new score is:");
                         System.out.println(getScore(board1));

                     }

                     for(int i=0;i<hand2.length;i++) {
                         if (hand2[i].getSpecial().equals("dbl")) {
                             System.out.println("ıf you want to play dbl please enter");
                             int x = sc.nextInt();
                             hand2[x] = null;
                         }

                         int y = board2[2].getNumber() * 2;
                         board2[2].setNumber(y);
                         System.out.println("Your new score is:");
                         System.out.println(getScore2(board2));
                     }
                     if (getScore(board1) == 20) {
                         System.out.println("Computer wins.");
                         System.out.println(getScore(board1));
                         System.out.println(getScore2(board2));
                         comppoint++;
                     } else if (getScore2(board2) == 20) {
                         System.out.println("You win.");
                         System.out.println(getScore(board1));
                         System.out.println(getScore2(board2));
                         playerpoint++;
                     }
                     if (getScore(board1) > 20) {
                         System.out.println("BUST FOR COMP");
                         System.out.println(board1[2]);
                         for (int i = 0; i < hand1.length; i++) {
                             if (hand1[i].getSign() == -1) {
                                 System.out.println("computer plays it's - card");
                                 //board1[6]=hand1[i];
                                 int z= board1[2].getNumber();
                                 z += hand1[i - 1].getNumber() * (-1);
                                 board1[2].setNumber(z);
                                 System.out.println("computer's new score is:");
                                 System.out.println(getScore(board1));
                                 if (getScore(board1) > 20 && getScore2(board2) < 20) {
                                     System.out.println("You win the tour.");
                                     System.out.println(getScore(board1));
                                     System.out.println(getScore2(board2));
                                     playerpoint++;
                                 }
                             }
                         }
                         for (int i = 0; i < hand1.length; i++) {
                             if (hand1[i] != null) {
                                 if (hand1[i].getSpecial().equals("flip")) {
                                     System.out.println("comp plays it's flip card");
                                     board1[2].setNumber(board1[2].getNumber() * (-1));
                                     System.out.println("computer's new score is:");
                                     System.out.println(getScore(board1));
                                     if (getScore(board1) > 20 && getScore2(board2) < 20) {
                                         System.out.println("You win the tour.");
                                         System.out.println(getScore(board1));
                                         System.out.println(getScore2(board2));
                                         playerpoint++;
                                     }

                                 }
                             }
                         }

                         if (getScore(board1) > getScore2(board2)) {
                             System.out.println("Computer wins the tour");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                             comppoint++;
                         } else if (getScore(board1) < getScore2(board2)) {
                             System.out.println("You win the tour.");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                             playerpoint++;
                         } else if (getScore(board1) == getScore2(board2)) {
                             System.out.println("1-1");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                         }
                         for (int i = 0; i < hand1.length; i++) {
                             if (hand1[i].getSign() != -1) {
                                 System.out.println("waiting for the player.");
                                 if (getScore(board1) > getScore2(board2)) {
                                     System.out.println("Computer wins the tour");
                                     System.out.println(getScore(board1));
                                     System.out.println(getScore2(board2));
                                     comppoint++;
                                 } else if (getScore(board1) < getScore2(board2)) {
                                     System.out.println("You win the tour.");
                                     System.out.println(getScore(board1));
                                     System.out.println(getScore2(board2));
                                     playerpoint++;
                                 } else if (getScore(board1) == getScore2(board2)) {
                                     System.out.println("1-1");
                                     System.out.println(getScore(board1));
                                     System.out.println(getScore2(board2));
                                 }
                             }
                         }

                     }
                     if (getScore2(board2) > 20) {
                         System.out.println("BUST");
                         System.out.println(board2[2]);
                         System.out.println("If you have - card you can play.");
                         System.out.println("If you don't have - card please enter 5 to wait computer.");
                         int r = sc.nextInt();
                         board2[6] = hand2[r - 1];
                         board2[6].setNumber(hand2[r - 1].getNumber() * (-1));
                         System.out.println("Your new score is:");
                         System.out.println(getScore2(board2));
                         for (int i = 0; i < hand2.length; i++) {
                             if (hand2[i] != null) {
                                 if (hand2[i].getSpecial().equals("flip")) {
                                     System.out.println("please make move.");
                                     int move = sc.nextInt();
                                     hand2[move] = null;
                                     board2[2].setNumber(board2[2].getNumber() * (-1));
                                     System.out.println("Your new score is:");
                                     System.out.println(getScore2(board2));

                                 }
                             }
                         }
                         if (getScore(board1) < 20 && getScore2(board2) > 20) {
                             System.out.println("Computer wins the tour.");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                             comppoint++;
                         } else if (getScore(board1) > getScore2(board2)) {
                             System.out.println("Computer wins the tour");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                             comppoint++;
                         } else if (getScore(board1) < getScore2(board2)) {
                             System.out.println("You win the tour.");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                             playerpoint++;
                         } else if (getScore(board1) == getScore2(board2)) {
                             System.out.println("1-1");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                         }
                         if (r == 5) {
                             if (getScore(board1) < 20 && getScore(board1) > getScore2(board2)) {
                                 System.out.println("computer wins.");
                                 System.out.println(getScore(board1));
                                 System.out.println(getScore2(board2));
                                 comppoint++;
                             }
                         }

                     }
                 } else if (choice2 == 2) {
                     System.out.println("waiting for the computer");
                     int p = getScore(board1);
                     int h = getScore2(board2);
                     if (p > h) {
                         System.out.println("computer wins");
                         System.out.println("Computer's score is:");
                         System.out.println(getScore(board1));
                         System.out.println("your score is:");
                         System.out.println(getScore2(board2));
                         comppoint++;

                     } else if (p < h) {
                         System.out.println("you win!!!!!!");
                         System.out.println("Computer's score is:");
                         System.out.println(getScore(board1));
                         System.out.println("your score is:");
                         System.out.println(getScore2(board2));
                         playerpoint++;

                     } else if (p == h) {
                         System.out.println("1-1");
                     }
                 }
                 System.out.println("computer's board is:" + board1[2]);
                 System.out.println("player's board is:" + board2[2]);
                 System.out.println("Computer's score is:");
                 System.out.println(getScore(board1));
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

                         }
                     }
                     for(int i=0;i<hand1.length;i++) {
                         if (hand1[i].getSpecial().equals("dbl")) ;
                         if (hand1[i].getNumber() < 11) {
                             System.out.println("comp plays it's dbl card");
                         }

                         int c = board1[3].getNumber() * 2;
                         board1[3].setNumber(c);
                         System.out.println("Computer's new score is:");
                         System.out.println(getScore(board1));
                     }


                     for(int i=0;i<hand2.length;i++){
                         if(hand2[i].getSpecial().equals("dbl"));
                         System.out.println("ıf you want to play dbl please enter");
                         int x=sc.nextInt();
                         hand2[x]=null;
                         int o=board2[3].getNumber()*2;
                         board2[3].setNumber(o);
                         System.out.println("Your new score is:");
                         System.out.println(getScore2(board2));
                     }
                     if (getScore(board1) == 20) {
                         System.out.println("Computer wins.");
                         System.out.println(getScore(board1));
                         System.out.println(getScore2(board2));
                         comppoint++;
                     } else if (getScore2(board2) == 20) {
                         System.out.println("You win.");
                         System.out.println(getScore(board1));
                         System.out.println(getScore2(board2));
                         playerpoint++;
                     }
                     if (getScore(board1) > 20) {
                         System.out.println("BUST FOR COMP");
                         System.out.println(board1[3]);
                         for (int i = 0; i < hand1.length; i++) {
                             if (hand1[i].getSign() == -1) {
                                 System.out.println("computer plays it's - card");
                                 // board1[7]=hand1[i];
                                 int w = board1[3].getNumber();
                                 w += hand1[i - 1].getNumber() * (-1);
                                 board1[3].setNumber(w);
                                 System.out.println("computer's new score is:");
                                 System.out.println(getScore(board1));
                                 if (getScore(board1) > 20 && getScore2(board2) < 20) {
                                     System.out.println("You win the tour.");
                                     System.out.println(getScore(board1));
                                     System.out.println(getScore2(board2));
                                     playerpoint++;
                                 }
                             }
                         }
                         for (int i = 0; i < hand1.length; i++) {
                             if (hand1[i] != null) {
                                 if (hand1[i].getSpecial().equals("flip")) {
                                     System.out.println("comp plays it's flip card");
                                     board1[3].setNumber(board1[3].getNumber() * (-1));
                                     System.out.println("computer's new score is:");
                                     System.out.println(getScore(board1));
                                     if (getScore(board1) > 20 && getScore2(board2) < 20) {
                                         System.out.println("You win the tour.");
                                         System.out.println(getScore(board1));
                                         System.out.println(getScore2(board2));
                                         playerpoint++;
                                     }

                                 }
                             }
                         }
                         if (getScore(board1) > 20 || getScore2(board2) > 20) {
                             System.out.println("Bust ");
                             break;
                         }

                         if (getScore(board1) > getScore2(board2)) {
                             System.out.println("Computer wins the tour");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                             comppoint++;
                         } else if (getScore(board1) < getScore2(board2)) {
                             System.out.println("You win the tour.");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                             playerpoint++;
                         } else if (getScore(board1) == getScore2(board2)) {
                             System.out.println("1-1");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                         }
                         for (int i = 0; i < hand1.length; i++) {
                             if (hand1[i].getSign() != -1) {
                                 System.out.println("waiting for the player.");
                                 if (getScore(board1) > getScore2(board2)) {
                                     System.out.println("Computer wins the tour");
                                     System.out.println(getScore(board1));
                                     System.out.println(getScore2(board2));
                                     comppoint++;
                                 } else if (getScore(board1) < getScore2(board2)) {
                                     System.out.println("You win the tour.");
                                     System.out.println(getScore(board1));
                                     System.out.println(getScore2(board2));
                                     playerpoint++;
                                 } else if (getScore(board1) == getScore2(board2)) {
                                     System.out.println("1-1");
                                     System.out.println(getScore(board1));
                                     System.out.println(getScore2(board2));
                                 }
                             }
                         }

                     }
                     if (getScore2(board2) > 20) {
                         System.out.println("BUST");
                         System.out.println(board2[3]);
                         System.out.println("If you have - card you can play.");
                         System.out.println("If you don't have - card please enter 5 to wait computer.");
                         int r = sc.nextInt();
                         board2[7] = hand2[r - 1];
                         board2[7].setNumber(hand2[r - 1].getNumber() * (-1));
                         System.out.println("Your new score is:");
                         System.out.println(getScore2(board2));
                         for (int i = 0; i < hand2.length; i++) {
                             if (hand2[i] != null) {
                                 if (hand2[i].getSpecial().equals("flip")) {
                                     System.out.println("please make move.");
                                     int move = sc.nextInt();
                                     hand2[move] = null;
                                     board2[3].setNumber(board2[3].getNumber() * (-1));
                                     System.out.println("Your new score is:");
                                     System.out.println(getScore2(board2));

                                 }
                             }
                         }
                         if (getScore(board1) < 20 && getScore2(board2) > 20) {
                             System.out.println("Computer wins the tour.");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                             comppoint++;

                         } else if (getScore(board1) > getScore2(board2)) {
                             System.out.println("Computer wins the tour");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                             comppoint++;
                         } else if (getScore(board1) < getScore2(board2)) {
                             System.out.println("You win the tour.");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                             playerpoint++;
                         } else if (getScore(board1) == getScore2(board2)) {
                             System.out.println("1-1");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                         }

                         if (r == 5) {
                             if (getScore(board1) < 20 && getScore(board1) > getScore2(board2)) {
                                 System.out.println("computer wins.");
                                 System.out.println(getScore(board1));
                                 System.out.println(getScore2(board2));
                                 comppoint++;
                             }
                         }

                     }
                 } else if (choice3 == 2) {
                     System.out.println("waiting for the computer");
                     int t = getScore(board1);
                     int y = getScore2(board2);
                     if (t > y) {
                         System.out.println("computer wins");
                         System.out.println("Computer's score is:");
                         System.out.println(getScore(board1));
                         System.out.println("your score is:");
                         System.out.println(getScore2(board2));
                         comppoint++;
                     } else if (t < y) {
                         System.out.println("you win!!!!!!");
                         System.out.println("Computer's score is:");
                         System.out.println(getScore(board1));
                         System.out.println("your score is:");
                         System.out.println(getScore2(board2));
                         playerpoint++;

                     } else if (t == y) {
                         System.out.println("1-1");
                     }
                 }
                 System.out.println("computer's board is:" + board1[3]);
                 System.out.println("player's board is:" + board2[3]);
                 System.out.println("Computer's score is:");
                 System.out.println(getScore(board1));
                 System.out.println("Your score is:");
                 System.out.println(getScore2(board2));
                 System.out.println("if you want another card please enter 1.");
                 System.out.println("if you want to stand please enter 2.");
                 int choice4 = sc.nextInt();
                 if (choice4 == 1) {
                     int h = rd.nextInt(10, 29);
                     board1[4] = deck[h];
                     int f = rd.nextInt(10, 29);
                     if (f != h) {
                         if (deck[f] != null) {
                             board2[4] = deck[f];
                         } else if (deck[f] == null) {
                             int v = rd.nextInt(10, 29);
                             board2[4] = deck[v];
                         }
                     }
                     for(int i=0;i<hand1.length;i++) {
                         if (hand1[i].getSpecial().equals("dbl")) ;
                         if (hand1[i].getNumber() < 11) {
                             System.out.println("comp plays it's dbl card");
                         }
                     }
                             int c=board1[4].getNumber()*2;
                             board1[4].setNumber(c);
                             System.out.println("Computer's new score is:");
                             System.out.println(getScore(board1));



                     for(int i=0;i<hand2.length;i++) {
                         if (hand2[i].getSpecial().equals("dbl")) {
                             System.out.println("ıf you want to play dbl please enter");
                             int x = sc.nextInt();
                             hand2[x] = null;
                             int q = board2[4].getNumber() * 2;
                             board2[4].setNumber(q);
                             System.out.println("Your new score is:");
                             System.out.println(getScore2(board2));
                         }
                     }
                     if (getScore(board1) == 20) {
                         System.out.println("Computer wins.");
                         comppoint++;
                     } else if (getScore2(board2) == 20) {
                         System.out.println("You win.");
                         playerpoint++;
                     }
                     if (getScore(board1) > 20) {
                         System.out.println("BUST FOR COMP");
                         System.out.println(board1[4]);
                         for (int i = 0; i < hand1.length; i++) {
                             if (hand1[i].getSign() == -1) {
                                 System.out.println("computer plays it's - card");
                                 //board1[8]=hand1[i];
                                 int d = board1[4].getNumber();
                                 d+= hand1[i - 1].getNumber() * (-1);
                                 board1[4].setNumber(d);
                                 System.out.println("computer's new score is:");
                                 System.out.println(getScore(board1));
                                 if (getScore(board1) > 20 && getScore2(board2) < 20) {
                                     System.out.println("You win the tour.");
                                     System.out.println(getScore(board1));
                                     System.out.println(getScore2(board2));
                                     playerpoint++;
                                 }
                             }
                         }
                         for (int i = 0; i < hand1.length; i++) {
                             if (hand1[i] != null) {
                                 if (hand1[i].getSpecial().equals("flip")) {
                                     System.out.println("comp plays it's flip card");
                                     board1[4].setNumber(board1[4].getNumber() * (-1));
                                     System.out.println("computer's new score is:");
                                     System.out.println(getScore(board1));
                                     if (getScore(board1) > 20 && getScore2(board2) < 20) {
                                         System.out.println("You win the tour.");
                                         System.out.println(getScore(board1));
                                         System.out.println(getScore2(board2));
                                         playerpoint++;
                                     }

                                 }
                             }
                         }

                         if (getScore(board1) > getScore2(board2)) {
                             System.out.println("Computer wins the tour");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                             comppoint++;
                         } else if (getScore(board1) < getScore2(board2)) {
                             System.out.println("You win the tour.");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                             playerpoint++;
                         } else if (getScore(board1) == getScore2(board2)) {
                             System.out.println("1-1");
                             System.out.println(getScore(board1));
                             System.out.println(getScore2(board2));
                         }
                         for (int i = 0; i < hand1.length; i++) {
                             if (hand1[i].getSign() != -1) {
                                 System.out.println("waiting for the player.");
                                 if (getScore(board1) > getScore2(board2)) {
                                     System.out.println("Computer wins the tour");
                                     System.out.println(getScore(board1));
                                     System.out.println(getScore2(board2));
                                     comppoint++;
                                 } else if (getScore(board1) < getScore2(board2)) {
                                     System.out.println("You win the tour.");
                                     System.out.println(getScore(board1));
                                     System.out.println(getScore2(board2));
                                     playerpoint++;
                                 } else if (getScore(board1) == getScore2(board2)) {
                                     System.out.println("1-1");
                                     System.out.println(getScore(board1));
                                     System.out.println(getScore2(board2));
                                 }
                             }
                         }

                     }
                     if (getScore2(board2) > 20) {
                         System.out.println("BUST");
                         System.out.println(board2[4]);
                         System.out.println("If you have - card you can play.");
                         System.out.println("If you don't have - card please enter 5 to wait computer.");
                         int r = sc.nextInt();
                         board2[8] = hand2[r - 1];
                         board2[8].setNumber(hand2[r - 1].getNumber() * (-1));
                         System.out.println("Your new score is:");
                         System.out.println(getScore2(board2));
                         for (int i = 0; i < hand2.length; i++) {
                             if (hand2[i] != null) {
                                 if (hand2[i].getSpecial().equals("flip")) {
                                     System.out.println("please make move.");
                                     int move = sc.nextInt();
                                     hand2[move] = null;
                                     board2[4].setNumber(board2[4].getNumber() * (-1));
                                     System.out.println("Your new score is:");
                                     System.out.println(getScore2(board2));

                                 }
                             }
                             if (getScore(board1) < 20 && getScore2(board2) > 20) {
                                 System.out.println("Computer wins the tour.");
                                 System.out.println(getScore(board1));
                                 System.out.println(getScore2(board2));
                                 comppoint++;
                             } else if (getScore(board1) > getScore2(board2)) {
                                 System.out.println("Computer wins the tour");
                                 System.out.println(getScore(board1));
                                 System.out.println(getScore2(board2));
                                 comppoint++;
                             } else if (getScore(board1) < getScore2(board2)) {
                                 System.out.println("You win the tour.");
                                 System.out.println(getScore(board1));
                                 System.out.println(getScore2(board2));
                                 playerpoint++;
                             } else if (getScore(board1) == getScore2(board2)) {
                                 System.out.println("1-1");
                                 System.out.println(getScore(board1));
                                 System.out.println(getScore2(board2));
                             }
                             if (r == 5) {
                                 if (getScore(board1) < 20 && getScore(board1) > getScore2(board2)) {
                                     System.out.println("computer wins.");
                                     System.out.println(getScore(board1));
                                     System.out.println(getScore2(board2));
                                     comppoint++;
                                 }
                             }

                         }
                     }

                 } else if (choice4 == 2) {
                     System.out.println("waiting for the computer");
                     int t = getScore(board1);
                     int y = getScore2(board2);
                     if (t > y) {
                         System.out.println("computer wins");
                         System.out.println("Computer's score is:");
                         System.out.println(getScore(board1));
                         System.out.println("your score is:");
                         System.out.println(getScore2(board2));
                         comppoint++;

                     } else if (t < y) {
                         System.out.println("you win!!!!!!");
                         System.out.println("Computer's score is:");
                         System.out.println(getScore(board1));
                         System.out.println("your score is:");
                         System.out.println(getScore2(board2));
                         playerpoint++;

                     } else if (t == y) {
                         System.out.println("1-1");
                     }
                 }
                 System.out.println("computer's board is:" + board1[4]);
                 System.out.println("player's board is:" + board2[4]);
                 System.out.println("Computer's score is:");
                 System.out.println(getScore(board1));
                 System.out.println("Your score is:");
                 System.out.println(getScore2(board2));

                 if (comppoint > playerpoint) {
                     System.out.println("Computer wins!!!!!!!!!!!!!!!");
                 } else if (playerpoint > comppoint) {
                     System.out.println("You win!!!!!!!!!!!!!!!");
                 }
                 for (int i = 0; i < board1.length; i++) {
                     board1[i] = null;
                 }
                 for (int i = 0; i < board2.length; i++) {
                     board2[i] = null;
                 }
            // }
           break;
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
        return sum;
    }
    public static int getScore2(Card[] board2) {
        int sum2 = 0;
        for (Card c : board2) {
            if (c != null) {
                sum2 += c.getNumber();
            }
        }
        return sum2;
    }
    }


