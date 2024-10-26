package racingcar.car;

import racingcar.validator.CarNameValidator;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        CarNameValidator.validate(name);
        this.name = name;
        this.position = 0;
    }

    public void move(int randomNumber){
        if(randomNumber >= 4) position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    // 테스트시 tearDown을 위한 메서드
    public void clearPosition(){
        this.position = 0;
    }
}
