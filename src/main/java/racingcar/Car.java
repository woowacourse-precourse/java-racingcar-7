package racingcar;

public class Car {
    private String name;

    public Car(String name) {
        this.name = setName(name);
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        if (name.length()>5)
            throw  new IllegalArgumentException("이름은 5자 이내로 입력하세요.");
        this.name = name;
        return name;
    }
}
