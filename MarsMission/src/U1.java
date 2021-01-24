import java.util.ArrayList;

public class U1 extends Rocket {

    public U1() {
        super(100000000, 10, 18, 1, 5);
        ArrayList U1Rockets = new ArrayList();
    }

    public String toString() {
        return ("U1 " + super.toString());
    }
    public boolean launch() {
        double randomizer = ((Math.random() * 100) + 1);
        double chanceOfExplosion = chanceOfLaunchExplosion * (1.0 * currentWeight / maxWeight);
        if (randomizer > chanceOfExplosion) {
            return true;
        }
        return false;
    }

    public boolean land() {
        double randomizer = (int) ((Math.random() * 100) + 1);
        // TODO: is it going to cause an issue that this division produces a double?
        double chanceOfLanding = chanceOfLandingCrash * (1.0 * currentWeight / maxWeight);
        if (randomizer > chanceOfLanding) {
            return true;
        }
        return false;
    }

    public boolean canCarry(Item item) {
        return super.canCarry(item);
    }

    public int carry(Item item) {
        return super.carry(item);
    }

    public static void main(String[] args) {
        U1 u1 = new U1();
        System.out.println(u1.rocketCost);
    }
}
