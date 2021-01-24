public class Main {
    public static void main(String[] args) {


//        System.out.println(item2.getItemWeightKg());
//        item2.itemWeightKg = 2;
//        System.out.println(item2.getItemWeightKg());

        String test = "testing this=123";
        String[] results = test.split("=");

        for (String s : results) {
            System.out.println(s);
        }

        System.out.println(results.toString());


    }
}
