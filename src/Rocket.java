public class Rocket implements SpaceShip {
    protected String name;
    protected double cost;
    protected double weight;
    protected double maxWeight;
    protected int chanceOfLaunchExplosion;
    protected int chanceOfLandingExplosion;

    public boolean land() {
        return true;
    }

    public boolean launch() {
        return true;
    }

    public boolean canCarry(Item item) {
        return item.weight + weight <= maxWeight;
    }

    public void carry(Item item) {
        weight += item.weight;
    }
}
