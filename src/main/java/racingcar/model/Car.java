package racingcar.model;

public class Car {

    private final String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        validateName();
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    private void validateName() {
        if (this.name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름 입력 길이를 초과하였습니다. (최대 5자)");
        }
    }

    public void moveFront(int randomNumber) {
        if (randomNumber < 4) {
            return;
        }
        position++;
    }
}
