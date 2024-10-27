package racingcar.domain.car;

public class RacingCar {

    private String name;
    private int forwardCount;

    public RacingCar(String name) {
        this.name = name;
        this.forwardCount = 0;
    }

    public void moveForward(int score) {
        if (score >= 4) {
            this.forwardCount++;
        }
    }

    public String getCurrentResultMessage() {
        String distance = "";
        for (int i = 0; i < forwardCount; i++) {
            distance += "-";
        }
        return this.name + " : " + distance;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }
}
