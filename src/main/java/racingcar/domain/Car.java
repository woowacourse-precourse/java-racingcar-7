package racingcar.domain;

public class Car {

    private String name;
    private int progress;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.progress = 0;
    }

    public Car(String name, int progress) {
        validateName(name);
        this.name = name;
        this.progress = progress;
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백이 될수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("5자 이하의 이름을 입력해주세요");
        }
    }

    public String name() {
        return name;
    }
}
