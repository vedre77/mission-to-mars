import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public ArrayList<Item> loadItems(String fileName) {
        ArrayList<Item> cargo = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String name = line.split("=")[0];
                String weight = line.split("=")[1];
                int weightToInt = Integer.parseInt(weight);
                Item item = new Item(name, weightToInt);
                cargo.add(item);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
        return cargo;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> itemList) {
        ArrayList<U1> loadedU1List = new ArrayList<>();
        U1 u1 = new U1();
        for (Item item : itemList) {
            while (item.weight > 0) {
                if (u1.canCarry(item)) {
                    u1.carry(item);
                    if (u1.weight == u1.maxWeight) {
                        loadedU1List.add(u1);
                        u1 = new U1();
                    }
                    item.weight=0;
                } else {
                    double cargoTaken = u1.maxWeight - u1.weight;
                    u1.weight = u1.maxWeight;
                    item.weight -= cargoTaken;
                    loadedU1List.add(u1);
                    u1 = new U1();
                }
            }
        }
        return loadedU1List;
    }
    public ArrayList<U2> loadU2(ArrayList<Item> itemList) {
        ArrayList<U2> loadedU2List = new ArrayList<>();
        U2 u2 = new U2();
        for (Item item: itemList) {
            while (item.weight > 0) {
                if (u2.canCarry(item)) {
                    u2.carry(item);
                    if (u2.weight == u2.maxWeight) {
                        loadedU2List.add(u2);
                        u2 = new U2();
                    }
                    item.weight=0;
                } else {
                    double cargoTaken = u2.maxWeight - u2.weight;
                    u2.weight = u2.maxWeight;
                    item.weight -= cargoTaken;
                    loadedU2List.add(u2);
                    u2 = new U2();
                }
            }
        }
        return loadedU2List;
    }

    public double runSimulation(ArrayList<? extends Rocket> rocketList) {
        double totalBudget = 0.0;
        for (Rocket rocket : rocketList) {
            totalBudget += rocket.cost;
            if (!rocket.launch() || !rocket.land()) {
                totalBudget += rocket.cost;
            }
        }
        String rocketType = rocketList.get(0).name;
        System.out.println("Total budget for sending " + rocketType +  " rockets: " + totalBudget + ".");
        return totalBudget;
    }

}
