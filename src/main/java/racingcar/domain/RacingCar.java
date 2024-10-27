package racingcar.domain;

public class RacingCar {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public RacingCar(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름으로 %s는 적절하지 않습니다.", name));
        }
    }

    public String getName() {
        return name;
    }


}
