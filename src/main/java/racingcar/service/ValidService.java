package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ValidService {
    public boolean isCarNames(String carNames){
        List<String> carList = List.of(carNames.split(","));
        carList.stream().map(String::trim);

        List<String> listCopy = carList.stream().distinct().collect(Collectors.toList());
        if(listCopy.size() != carList.size()){
            return false;
        }
        if(!carList.contains("pobi") || !carList.contains("woni")){
            return false;
        }
        for(String car : carList){
            if(car.isEmpty() || car.equals(" ")){
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
