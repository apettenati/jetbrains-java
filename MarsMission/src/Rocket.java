public class Rocket implements Spaceship {
    static int rocketCost; //dollars
    int rocketWeight; // tonnes
    int currentWeight; // current tonnes with cargo
    int maxWeight; // max tonnes with cargo
    int chanceOfLaunchExplosion; // % chance of explosion
    int chanceOfLandingCrash; // % chance of crash

    public Rocket(int rocketCost, int rocketWeight, int maxWeight, int chanceOfLandingCrash, int chanceOfLaunchExplosion) {
        this.rocketCost = rocketCost;
        this.rocketWeight = rocketWeight;
        this.maxWeight = maxWeight;
        this.chanceOfLaunchExplosion = chanceOfLaunchExplosion;
        this.chanceOfLandingCrash = chanceOfLandingCrash;
        this.currentWeight = rocketWeight;
    }

    public String toString() {
        String string = "Rocket currentWeight: " + this.currentWeight;
        return string;
    }

    public boolean canCarry(Item item) {
        if (currentWeight + item.itemWeightTonne() <= maxWeight) {
            return true;
        }
        return false;
    }

    public int carry(Item item) {
        if (canCarry(item)) {
            currentWeight = currentWeight + item.itemWeightTonne();
        }
        return currentWeight;
    }

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }
}
