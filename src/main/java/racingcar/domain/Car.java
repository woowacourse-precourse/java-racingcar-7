package racingcar.domain;

public class Car {
    // 이름, 위치
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 공백일 수 없습니다.");
        } else if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하가 되어야합니다.");
        }

        this.name = name;
    }


}
