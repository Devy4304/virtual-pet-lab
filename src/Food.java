public class Food {
    private final String foodName;
    private final int energyIncrease;
    private final int happinessIncrease;
    private final int weightGain;
    private final double cost;

    public Food(String foodName, int energyIncrease, int happinessIncrease, int weightGain, double cost) {
        this.foodName = foodName;
        this.energyIncrease = energyIncrease;
        this.happinessIncrease = happinessIncrease;
        this.weightGain = weightGain;
        this.cost = cost;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getEnergyIncrease() {
        return energyIncrease;
    }

    public int getHappinessIncrease() {
        return happinessIncrease;
    }

    public int getWeightGain() {
        return weightGain;
    }

    public double getCost() {
        return cost;
    }
}
