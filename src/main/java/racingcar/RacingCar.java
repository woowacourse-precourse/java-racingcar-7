package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private List<String> inputStringList = new ArrayList<>();
    private List<Car> carList = new ArrayList<>();
    private int count = 0;
    RacingCar(){
        this.inputStringList = Input.getNameList();
        this.count = Input.inputNumber();
    }

    private void setCarList() {
        for (String inputString : inputStringList) {
            throwErrorNameRule(inputString);
            this.carList.add(new Car(inputString));
        }
    }

    private void throwErrorNameRule(String inputString){
        if (inputString.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void run() {
        setCarList();
    }
}
