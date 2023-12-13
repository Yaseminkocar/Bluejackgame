public class Card {
    private int number;
    private String colour;
    private int sign;
    private String dbl;
    private String flip;

    public Card(int b, String c) {

        number = b;
        colour = c;
    }

    public Card(int i, String j, int k) {
        number = i;
        colour = j;
        sign = k;

    }

    public Card(String t, String m) {
        dbl = t;
        flip = m;
    }

    public int getValue() {
        return sign * number;
    }

    public void setSign(int v) {
        if (v < 0) {
            sign = -1;
        }
        if (v > 0) {
            sign = 1;
        }
    }


    @Override
    public String toString() {
        return number + " " + colour + " " + sign;

    }
}