import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulation {

    public Simulation() {
    }

    public List<Item> scanItems(String fileName) {
        List<Item> itemList = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] itemArray = line.split("=");
                String itemName = itemArray[0];
                String itemWeight = itemArray[1];
                int itemWeightInt = Integer.parseInt(itemWeight);
                Item item = new Item(itemName, itemWeightInt);
                itemList.add(item);
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File not found" + exception);
        }
        return itemList;
    }

    public List<U1> loadU1(List<Item> items) {
        List<U1> U1Rockets = new ArrayList<>();
        U1 rocket = new U1();
        U1Rockets.add(rocket);
        for (Item item : items) {
            if (!rocket.canCarry(item)) {
                rocket = new U1();
                U1Rockets.add(rocket);
            }
            rocket.carry(item);
        }
        return U1Rockets;
    }

    public List<U2> loadU2(List<Item> items) {
        List<U2> U2Rockets = new ArrayList<>();
        U2 rocket = new U2();
        U2Rockets.add(rocket);
        for (Item item : items) {
            if (!rocket.canCarry(item)) {
                rocket = new U2();
                U2Rockets.add(rocket);
            }
            rocket.carry(item);
        }
        return U2Rockets;
    }

    public int runU1Simulation(List<Item> itemList) {
        List<U1> U1Rockets = loadU1(itemList);
        ArrayList<U1> totalU1Rockets = new ArrayList<>();
        for (U1 currentRocket : U1Rockets) {
            while (!currentRocket.launch() || !currentRocket.land()) {
                totalU1Rockets.add(currentRocket);
            }
            totalU1Rockets.add(currentRocket);
        }
        int totalBudgetU1 = totalU1Rockets.size() * U1.rocketCost;
        return totalBudgetU1;
    }

    public int runU2Simulation(List<Item> itemList) {
        List<U2> U2Rockets = loadU2(itemList);
        ArrayList<U2> totalU2Rockets = new ArrayList<>();
        for (U2 currentRocket : U2Rockets) {
            while (!currentRocket.launch() || !currentRocket.land()) {
                totalU2Rockets.add(currentRocket);
            }
            totalU2Rockets.add(currentRocket);
        }
        int totalBudgetU1 = totalU2Rockets.size() * U1.rocketCost;
        return totalBudgetU1;
    }

    public String runSimulation(String fileName) {
        List<Item> itemList = scanItems(fileName);
        int totalBudgetU1MM = runU1Simulation(itemList) / 1000000;
        int totalBudgetU2MM = runU2Simulation(itemList) / 1000000;
        String cheaper;
        String returnValue = "";
        if (totalBudgetU1MM < totalBudgetU2MM) {
            cheaper = "U1 is cheaper:";
        } else {
            cheaper = "U2 is cheaper:";
        }
        returnValue += cheaper + "\n";
        returnValue += "U1 total budget is $" + totalBudgetU1MM + " million. \n";
        returnValue += "U2 total budget is $" + totalBudgetU2MM + " million.";
        return returnValue;
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        System.out.println(simulation.runSimulation("phase-1.txt"));
        Simulation simulation2 = new Simulation();
        System.out.println(simulation2.runSimulation("phase-2.txt"));
    }
}