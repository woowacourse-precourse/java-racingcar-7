package racingcar;


public class RacingCar {

    private final String name;
    private int position;

    public RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
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

    public void move() {
        position += 1;
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}
