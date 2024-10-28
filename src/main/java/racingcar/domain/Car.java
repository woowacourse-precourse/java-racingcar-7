package racingcar.domain;

import java.util.regex.Pattern;

public class Car {
    private static final String VALID_CHARACTER_REGEX = "^[a-zA-Z0-9가-힣]+$";
    private final String name;
    private int position;
    public Car(String name){
        validateName(name); // 자동차 이름
        this.name = name;
        this.position = 0;
    }
    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        if (!Pattern.matches(VALID_CHARACTER_REGEX, name)) {
            throw new IllegalArgumentException("자동차 이름은 영어, 숫자, 한글만 사용 가능합니다.");
        }
    }

    public void move(int number) {
        if (number >= 4) {
            position++;
        }
    }
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionDisplay() {
        return "-".repeat(position); // 턴 진행 시 현재 position 출력하도록 처리
    }
}
