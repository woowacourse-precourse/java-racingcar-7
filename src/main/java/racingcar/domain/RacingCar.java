package racingcar.domain;

public class RacingCar {

    private final String name;
    private int position = 0;

    public RacingCar(String name) {
        name = name.strip();

        validateName(name);

        this.name = name;
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 여야 합니다.");
        }

        //TODO : 상수 처리
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하 여야 합니다.");
        }
    }

    public void move(int input) {
        // TODO : 4 상수 처리
        if (input >= 4) {
            go();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void go() {
        position++;
    }
}
