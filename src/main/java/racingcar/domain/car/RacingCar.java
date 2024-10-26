package racingcar.domain.car;

public class RacingCar {

    private String name;
    private int forwardCount;

    public RacingCar(String name) {
        this.name = name;
        this.forwardCount = 0;
    }

    public void forwardCar(int score) {
        if (score >= 4) {
            this.forwardCount++;
        }
    }

    public void printCurrentResult() {
        String distance = "";
        for (int i = 0; i < forwardCount; i++) {
            distance += "-";
        }
        System.out.println(this.name + " : " + distance);
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }
}
