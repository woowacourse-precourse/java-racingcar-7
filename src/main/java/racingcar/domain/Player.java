package racingcar.domain;

public class Player {
    private String carName;
    private int position;

    public Player(String carName, int position) {
        validateCarName(carName);
        validatePosition(position);
        this.carName = carName;
        this.position = position;
    }

    public static Player createPlayer(String carName) {
        return new Player(carName, 0);
    }

    private void validateCarName(String carName) {
        validateBlank(carName);
        validateCarNameLength(carName);
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() <= 0 || carName.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 1글자 이상 5글자 이하만 가능합니다.");
        }
    }

    private void validateBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름에 공백이 입력되었습니다.");
        }
    }

    private void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("자동차 위치에 음수가 입력되었습니다.");
        }
    }

    public void moveCar(int add) {
        if (add < 0) {
            throw new IllegalArgumentException("전진은 양수만 가능합니다.");
        }
        position += add;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
