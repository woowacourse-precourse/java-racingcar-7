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

    public int validateGameCount(int input){
        if(input <= 0){
            throw new IllegalArgumentException("게임횟수는 1부터 입력 가능합니다");
        }
        return input;
    }
}
