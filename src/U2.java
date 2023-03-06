public class U2 extends  Rocket {

    public U2() {
        this.name = "U2";
        this.cost = 120_000;
        this.weight = 18;
        this.maxWeight = 29;
        this.chanceOfLaunchExplosion = 4;
        this.chanceOfLandingExplosion = 8;
    }

    @Override
    public boolean land() {
        double explosionChance = 4 * (this.weight / this.maxWeight);
        int chanceLimit = (int) (Math.random() * 100 + 1);
        return !(chanceLimit < explosionChance);
    }

    @Override
    public boolean launch() {
        double explosionChance = 8 * (this.weight / this.maxWeight);
        int chanceLimit = (int) (Math.random() * 100 + 1);
        return !(chanceLimit < explosionChance);
    }

    @Override
    public String toString() {
        return "U2{" +
                "weight=" + weight +
                "} " + super.toString();
    }
}
