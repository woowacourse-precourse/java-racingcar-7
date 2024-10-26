package racingcar.controller;

import java.util.List;

public class Validator {
    public List<String> validateCarName(String input){
        List<String> carNameList = List.of(input.split(","));
        for(String name : carNameList){
            if(name.length() > 5){
                throw new IllegalArgumentException("이름은 5글자 이하로 입력해주세요.");
            }
        }
        return carNameList;
    }


}
