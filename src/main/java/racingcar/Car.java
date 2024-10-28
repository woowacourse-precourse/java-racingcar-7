package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car (String _name) {
        name = _name;
        position = 0;
    }

    public void move() {
        int randomValue = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
