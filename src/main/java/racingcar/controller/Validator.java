package racingcar.controller;

import racingcar.common.ExceptionMessage;

import java.util.List;

public class Validator {

    public static void validateUserInput(List<String> userInputs){
        if(userInputs.get(0).isEmpty()){
            throw new IllegalArgumentException(ExceptionMessage.NAME_INVALID_EMPTY.getMessage());
        }
        if(!userInputs.get(1).matches("[0-9]+")){
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_INVALID_FORMAT.getMessage());
        }
        for(String name : NameExtractor.extractNames(userInputs.get(0))){
            if(name.isEmpty()){
                throw new IllegalArgumentException(ExceptionMessage.NAME_INVALID_EMPTY.getMessage());
            }
        }
        if(userInputs.get(0).endsWith(",")){
            throw new IllegalArgumentException(ExceptionMessage.NAME_INVALID_EMPTY.getMessage());
        }
    }
}
