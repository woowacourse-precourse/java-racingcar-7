package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private List<Car> carList = new ArrayList<>();
    private int count = 0;

    public void setCarList(List<String> inputStringList) {
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
        List<String> inputStringList = Input.getNameList();
        this.count = Input.inputNumber();
        setCarList(inputStringList);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
