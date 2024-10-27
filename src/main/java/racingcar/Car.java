package racingcar;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.distance = 0;
    }

    //이것들도 다 분리를 해야되나?
    private void validateName(String name) {
        String regex = "^[a-zA-Z]+$";

        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이상이 될 수 없습니다.");
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException("공백은 이름이 될 수 없습니다.");
        }

        if (!name.matches(regex)) {
            throw new IllegalArgumentException("이름은 영어(알파벳)로만 생성할 수 있습니다.");
        }
    }
}
