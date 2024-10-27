package racingcar.domain;

public class RacingCar {
    private final String name;

    public RacingCar(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 필수입니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차는 5자리 이하 이름만 지정할 수 있습니다.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
