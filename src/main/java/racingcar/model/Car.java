package racingcar.model;

public class Car {

    private String name;

    public Car(String name) {
        this.name = name;
        validateName();
    }

    private void validateName() {
        if (this.name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름 입력 길이를 초과하였습니다. (최대 5자)");
        }
    }
}
