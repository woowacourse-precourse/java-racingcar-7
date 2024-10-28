package racingcar;

public class Car {
    private final String name;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
        if(name.isBlank()){
            throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
