import java.util.HashMap;

public class Bins extends Dice {


    public Bins(int count) {
        super(count);
    }

    public static void main(String[] args) {

        Bins bins = new Bins(2);
        Integer occurence = bins.getBin(6,1000);
        System.out.println(occurence);
        int numIncrement = bins.incrementBin(6);
        System.out.println(numIncrement);

    }

 public int incrementBin(int bin){
     Bins bins = new Bins(2);
     Integer occurence = bins.getBin(bin,1000);
     return  occurence+1;
 }


}
