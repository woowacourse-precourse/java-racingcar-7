package racingcar.service;

import java.util.List;

public class ValidService {
    public boolean isCarNames(String carNames){
        List<String> carList = List.of(carNames.split(","));
        for(String car : carList){
            if(car.isEmpty()){
                return false;
            }
        }
        return true;
    }

    public boolean isRepeat(String inputNum){
        for(int i=0; i<inputNum.length(); i++){
            char num = inputNum.charAt(i);
            if((int)num < (int)'0' || (int)num > (int)'9'){
                return false;
            }
        }
        return true;
    }
}
