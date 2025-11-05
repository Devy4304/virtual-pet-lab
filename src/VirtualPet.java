public class VirtualPet {
    private final String name;
    private int energyLevel;
    private int happiness;
    private int weight;
    private int ageYears;
    private int ageMonths;
    private double accountBalanceUSD;
    private boolean isDead;

    public VirtualPet(String name) {
        this.name = name;
        accountBalanceUSD = 10;
        energyLevel = 5;
        happiness = 5;
        weight = (int)(Math.random() * 21 + 10);
        ageMonths = 0;
        ageYears = 0;
        isDead = false;
    }

    public void feed(Food foodItem) {
        if (!isDead) {
            if (accountBalanceUSD - foodItem.getCost() >= 0) {
                energyLevel = bound(0, energyLevel += foodItem.getEnergyIncrease(), 10);
                happiness = bound(0, happiness += foodItem.getHappinessIncrease(), 10);
                weight += foodItem.getWeightGain(); // if food is implemented, change these values based on the food object
                accountBalanceUSD -= foodItem.getCost();
            } else {
                Utility.Console.writeTUIBox("You don't have enough money;Consider making more", false, false);
            }
        }
    }

    public boolean play(Game game) {
        if (!isDead) {
            weight = bound(5, weight -= game.getWeightDecr(), Integer.MAX_VALUE); // cap to minimum of 5
            if (game.isWinner()) {
                happiness = bound(0, happiness += game.getHappinessIncr(), 10); // keep in bounds
                return true;
            } else {
                happiness = bound(0, happiness -= game.getHappinessIncr(), 10); // keep in bounds
                return false;
            }
        } else return false;
    }

    public void updateStatus() {
        if (!isDead) {
            happiness = bound(0, happiness--, 10);
            energyLevel = bound(0, energyLevel--, 10);
            ageMonths++;
            if (ageMonths % 12 == 0) {
                ageYears++;
            }
            if (ageYears > 12) {
                isDead = true;
                Utility.Console.writeTUIBox("Your pet is dead, haha.", false, false);
            }
        }
    }

    public boolean isDead() {
        return isDead;
    }

    public void kill() {
        isDead = true;
    }

    private int bound(int min, int value, int max) {
        return Math.max(min, Math.min(value, max));
    }

    public String getName() {
        return name;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public int getHappiness() {
        return happiness;
    }

    public double getAccountBalance() {
        return accountBalanceUSD;
    }

    public void withdrawOrDepositMoney(double amount) {
        accountBalanceUSD += amount;
    }

    public void gamble(double amount) {
        if (!isDead) {
            amount = Math.abs(amount); // no cheating, negative numbers not welcome here.
            Utility.Console.writeTUIBox("Gambling $" + amount + "!", true, false);
            Utility.Console.writeTUIBox("Would you like to bet on " + Utility.Console.Colors.RED + "RED" + Utility.Console.Colors.RESET + " or " + Utility.Console.Colors.GREEN + "GREEN" + Utility.Console.Colors.RESET +
                    "?; 1) " + Utility.Console.Colors.RED + "RED" + Utility.Console.Colors.RESET +
                    "; 2) " + Utility.Console.Colors.GREEN + "GREEN" + Utility.Console.Colors.RESET,
                    false, true
            );
            int choice = Utility.Console.getNumericalInput(1, 2);
            int correct = (int)(Math.random() * 2 + 1);
            if (choice == correct) {
                withdrawOrDepositMoney(amount);
                Utility.Console.writeTUIBox("You won: $" + (amount), false, false);
            } else {
                withdrawOrDepositMoney(amount * -1);
                Utility.Console.writeTUIBox("You lost: $" + (amount ), false, false);
            }
        }
    }

    public void discipline(int amount) {
        if (!isDead) {
            happiness = bound(0, happiness -= bound(-4, amount, 4), 10);
        }
    }

    public String toString() {
        return name +
                "\n - Energy Level: " + energyLevel +
                "\n - Happiness Level: " + happiness +
                "\n - Weight: " + weight +
                "\n - Age: " + ageMonths + " month" + ((ageMonths > 1) ? "" : "s") +", " + ageYears + "year" + ((ageYears > 1) ? "" : "s");
    }
}