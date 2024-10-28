package racingcar.car;


public class RacingCar extends Car {

    public RacingCar(String name, int position) {
        super(name, position);
    }

    public static RacingCar from(String name) {
        validateNameLength(name);
        return new RacingCar(name, 0);
    }

    private static void validateNameLength(String name) {
        int maxNameLength = 5;
        if (name.isEmpty() || name.length() > maxNameLength) {
            throw new IllegalArgumentException("자동차 이름은 1~5글자입니다.");
        }
    }

    @Override
    public void move() {
        position += 1;
    }

    @Override
    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }
}
