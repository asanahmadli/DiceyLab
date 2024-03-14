import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class Dice {

    private final int count;

    public Dice(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }


    public HashMap<Integer, Integer> tossAndSum(int toss) {

        HashMap<Integer, Integer> hash = new HashMap<>();
        Random random = new Random();
        int sum = 0;

        //fill hashmap keys
        for (int i = count; i <= 6 * count; i++) {
            hash.put(i, 0);
        }

        for (int i = 0; i < toss; i++) {

            sum = 0;
            for (int m = 1; m <= count; m++) {
                int dice = random.nextInt(6) + 1;
                sum += dice;
            }

            int a = hash.get(sum);
            a++;
            hash.put(sum, a);
        }

        return hash;

    }

    public int getBin(int bin, int toss) {
        HashMap<Integer, Integer> hash = tossAndSum(toss);
        return hash.get(bin);
    }

    public void printResults(int toss, int count) {
        Dice dice = new Dice(count);
        HashMap<Integer, Integer> hash = dice.tossAndSum(toss);
        StringBuilder sb = new StringBuilder();


        for (int i = dice.count; i <= 6 * dice.count; i++) { // rolling 1 to 6
            sb.append(String.format("%2d : %8d: %.2f ", i, dice.getBin(i, toss), (double) dice.getBin(i, toss) / toss)); // percentage
            for (int j = 0; j < (double) dice.getBin(i, toss) / toss * 100; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("/Users/asan/Desktop/Projects/DiceyLab/AsanResult.txt");
            printWriter.println(sb.toString());
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}//class