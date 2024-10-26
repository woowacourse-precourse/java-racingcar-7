package racingcar.Domain;

public class Car {
    private final String name;

    public Car(String name) {
        this.name = name;
    }
    private void validNameLength(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("이름은 다섯자 이내로 입력하세요");
        }
    }

}
