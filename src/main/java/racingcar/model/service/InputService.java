package racingcar.model.service;
import camp.nextstep.edu.missionutils.Console;
import racingcar.model.dto.Car;

import java.util.ArrayList;
import java.util.List;

public class InputService {

    public String inputValue(){
        return Console.readLine();
    }

    public List<Car> inputValidator(String carValue, String countValue){
        if(carValue.isEmpty() || countValue.isEmpty() || carValue == null || countValue == null){
            throw new IllegalArgumentException("입력값이 누락되었습니다.");
        }

        String[] cars = splitCarValue(carValue);
        List<Car> carList = new ArrayList<>();
        for (String car : cars) {
            if(car.length() > 5){
                throw new IllegalArgumentException("자동차 이름의 입력값은 최대 5자입니다.");
            }
            Car carInfo = new Car(car, 0);
            carList.add(carInfo);
        }

        return carList;
    }

    private String[] splitCarValue(String carValue){
        return carValue.split(",");
    }

}
