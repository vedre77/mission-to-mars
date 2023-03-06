import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Simulation simulation = new Simulation();
        ArrayList<Item> phase1cargo = simulation.loadItems("phase_one.txt");
        ArrayList<Item> phase2cargo = simulation.loadItems("phase_two.txt");
        ArrayList<U1> rocketListU1 = simulation.loadU1(phase1cargo);
        ArrayList<U1> rocketListU1_1 = simulation.loadU1(phase2cargo);
        rocketListU1.addAll(rocketListU1_1);
        simulation.runSimulation(rocketListU1);

        Simulation simulation2 = new Simulation();
        ArrayList<Item> phase3cargo = simulation2.loadItems("phase_one.txt");
        ArrayList<Item> phase4cargo = simulation2.loadItems("phase_two.txt");
        ArrayList<U2> rocketListU2 = simulation2.loadU2(phase3cargo);
        ArrayList<U2> rocketListU2_1 = simulation2.loadU2(phase4cargo);
        rocketListU2.addAll(rocketListU2_1);
        simulation.runSimulation(rocketListU2);
    }
}
