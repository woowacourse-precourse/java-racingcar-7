package racingcar.model;

public class Car {

    private final String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        validateName();
    }

    private void validateName() {
        if (this.name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 공백으로 입력되었습니다.");
        }
        if (this.name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름 입력 길이를 초과하였습니다. (최대 5자)");
        }
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }


    public void moveFront(int randomNumber) {
        if (randomNumber < 4) {
            return;
        }
        position++;
    }
}
