public class Game {
    private final String gameName;
    private final int happinessIncr;
    private final int weightDecr;

    public Game(String gameName, int happinessIncr, int weightDecr) {
        this.gameName = gameName;
        this.happinessIncr = happinessIncr;
        this.weightDecr = weightDecr;
    }

    public String getGameName() {
        return gameName;
    }

    public int getHappinessIncr() {
        return happinessIncr;
    }

    public int getWeightDecr() {
        return weightDecr;
    }

    public boolean isWinner() {
        return (Math.random() >= 0.5);
    }
}
