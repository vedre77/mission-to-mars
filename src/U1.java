public class U1 extends Rocket {

    public U1() {
        this.name = "U1";
        this.cost = 100_000;
        this.weight = 10;
        this.maxWeight = 18;
        this.chanceOfLaunchExplosion = 5;
        this.chanceOfLandingExplosion = 1;
    }
//    Chance of launch explosion = 5% * (cargo carried / cargo limit)
//    Chance of landing crash = 1% * (cargo carried / cargo limit)
    @Override
    public boolean land() {
        double explosionChance = 5 * (this.weight / this.maxWeight);
        int chanceLimit = (int) (Math.random() * 100 + 1);
        return !(chanceLimit < explosionChance);
    }

    @Override
    public boolean launch() {
        double explosionChance = this.weight / this.maxWeight;
        int chanceLimit = (int) (Math.random() * 100 + 1);
        return !(chanceLimit < explosionChance);
    }

    @Override
    public String toString() {
        return "U1{" +
                "weight=" + weight +
                "} " + super.toString();
    }
}
