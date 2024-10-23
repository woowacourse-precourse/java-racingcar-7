package racingcar.model;

public class RacingCar {

    private final String name;
    private final int position;
    private final int DEFAULT_POSITION = 0;
    private final int MAX_NAME_LENGTH = 5;

    public RacingCar(String name) {
        validateName(name);
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
