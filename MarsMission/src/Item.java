import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Item {
    public String itemName;
    public int itemWeightKg; // in Kgs

    public Item(String name, int weight) {
        this.itemName = name;
        this.itemWeightKg = weight;
    }

    public Item() {

    }

    public int itemWeightTonne() {
        int itemWeightTonne = this.itemWeightKg / 1000;
        return itemWeightTonne;
    }

    public String getItemName() {
        return this.itemName;
    }

    public int getItemWeightKg() {
        return this.itemWeightKg;
    }

    public String toString() {
        String string = "Name: " + this.itemName + ", Weight (Kg): " + this.itemWeightKg;
        return string;
    }

    public static void main(String[] args) {
//        Item item = new Item("fjdk", 10);
//        Item item2 = (new Item("test",1));
//        List<Item> testList = new ArrayList();
//        testList.add(item);
//        testList.add(item);
//        testList.add(item);
//        testList.add(item);
//        testList.add(item2);
//        testList.add(new Item("test2", 1));
//
//        System.out.println(testList);
//        System.out.println(item2.getItemWeightKg());
//        item2.itemWeightKg = 2;
//        System.out.println(item2.getItemWeightKg());
    }
}
