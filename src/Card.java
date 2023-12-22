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
    public void setNumber(int n){
        number =n;
    }
    public int getNumber(){
        return number ;
    }
    public String getSpecial(){
        return special;
    }
    public void setSign(int t,int k){
        sign=t;
        number=k;
    }
    public int getSign(){
        return sign;
    }
    @Override
    public String toString() {
        if(!special.equals("")) return special;
        return number + " " + colour + " " + sign+" "+special;

    }
}
