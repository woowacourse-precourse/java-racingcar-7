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
        if(userInputs.get(0).endsWith(",")){
            throw new IllegalArgumentException(ExceptionMessage.NAME_INVALID_EMPTY.getMessage());
        }
        List<String> names = NameExtractor.extractNames(userInputs.get(0));
        for(String name : names){
            if(!name.matches(".{1,5}")){
                throw new IllegalArgumentException(ExceptionMessage.NAME_INVALID_LETTER_SIZE.getMessage());
            }
        }
        if(names.size() != names.stream().distinct().count()){
            throw new IllegalArgumentException(ExceptionMessage.NAME_INVALID_DUPLICATED_NAME.getMessage());
        }
    }
}
