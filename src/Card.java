public class Card {
    private int number;
    private String colour;
    private int sign;
    private String special;





    public Card(int i, String j, int k,String c) {
        number = i;
        colour = j;
        sign = k;
        special=c;
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
        return number + " " + colour + " " + sign+" "+special;

    }
}
