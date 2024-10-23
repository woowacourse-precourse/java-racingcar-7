package racingcar.model.service;
import camp.nextstep.edu.missionutils.Console;
import racingcar.model.dto.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputService {

    public String inputValue(){
        return Console.readLine();
    }

    public List<Car> inputValidator(String carValue, String countValue){
        if(carValue.isEmpty() || countValue.isEmpty() || carValue == null || countValue == null){
            throw new IllegalArgumentException("입력값이 누락되었습니다.");
        }

        List<String> cars = splitCarValue(carValue);
        List<Car> carList = new ArrayList<>();
        for (String car : cars) {
            if(car.length() > 5){
                throw new IllegalArgumentException("자동차 이름의 입력값은 최대 5자입니다.");
            }
            Car carInfo = new Car(car, 0);
            carList.add(carInfo);
        }

        if(!isNumeric(countValue)){
            throw new IllegalArgumentException("시도할 횟수는 숫자여야합니다.");
        }

        return carList;
    }

    private List<String> splitCarValue(String carValue){
        return Arrays.asList(carValue.split(","));
    }

    private boolean isNumeric(String countValue){
        try{
            Integer.parseInt(countValue);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

}
