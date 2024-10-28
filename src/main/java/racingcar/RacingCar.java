package racingcar;

public class RacingCar {
    private static final int MOVE_NUMBER = 4;
    private final String name;
    private int count;

    public RacingCar(String name) {
        this.name = name;
    }

    public void move() {
        if (RandomPicker.getRandomNumber() >= MOVE_NUMBER) {
            this.count++;
        }
        IOHandler.resultMessage(this);
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
