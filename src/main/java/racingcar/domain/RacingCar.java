package racingcar.domain;

public class RacingCar {
    private final String name;
    private int position;

    public RacingCar(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public RacingCar(String name, int startPosition) {
        this.name = name;
        this.position = startPosition;
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 필수입니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차는 5자리 이하 이름만 지정할 수 있습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public void move(int number) {
        if (number >= 4) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}
