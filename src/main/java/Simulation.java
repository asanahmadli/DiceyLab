public class Simulation extends Dice{


    private int toss;
    public Simulation(int count,int toss) {
        super(count);
        this.toss = toss;
    }


    public static void main(String[] args) {
        Simulation sim = new Simulation(2, 1000000);

        sim.printResults(sim.toss,sim.getCount());
    }



}
