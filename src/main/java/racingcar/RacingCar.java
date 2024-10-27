package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionWithDash() {
        StringBuilder dashPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            dashPosition.append("-");
        }
        return dashPosition.toString();
    }
}
