package racingcar;

public class Player {
    private final String name;
    private int distance;

    public Player(String name) {
        this.name = name;
    }

    public void move() {
        this.distance++;
    }

    public boolean isWinner(int maxDistance) {
        return maxDistance == this.distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }


}
