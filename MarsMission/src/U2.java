import java.util.ArrayList;

public class U2 extends Rocket {

    public U2() {
        super(120000000, 18, 29, 8, 4);
        ArrayList U2Rockets = new ArrayList();
    }

    public String toString() {
        return ("U2 " + super.toString());
    }
    public boolean launch() {
        double randomizer = ((Math.random() * 100) + 1);
        // TODO: is it going to cause an issue that this division produces a double?
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

}
