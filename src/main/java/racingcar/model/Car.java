package racingcar.model;

public class Car {
    private String name;
    private int moveDistance;

    public Car(String name) {
        validateCarNameLengthAndBlank(name);
        this.name = name;
        this.moveDistance = 0;
    }

    public void validateCarNameLengthAndBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("이름으로 공백이나 빈 칸은 허용하지 않습니다.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름은 5자리 이하로 입력해주세요.");
        }
    }

    public String getName() {
        return name;
    }
}
