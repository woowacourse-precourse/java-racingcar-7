package racingcar;


import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;

        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        if (randomInt() >= 4) {
            distance++;
        }
    }

    public int randomInt() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String getlength(int distance) {
        return "-".repeat(distance);
    }


}
