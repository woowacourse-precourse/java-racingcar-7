package racingcar.valid;

import racingcar.constants.GameConstatns;
import racingcar.exception.ExceptionMessage;
import racingcar.model.Game;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameValid {
    public static void checkNamesInput(String names){
        if(!names.matches(GameConstatns.CAR_NAMES_REGEX)){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NAME_FORMAT);
        }
    }

    public static void checkNameCount(int count){
        if(count < GameConstatns.CAR_COUNT_MIN){
            throw new IllegalArgumentException(ExceptionMessage.CAR_COUNT_UNDER);
        }
        if(count > GameConstatns.CAR_COUNT_MAX){
            throw new IllegalArgumentException(ExceptionMessage.CAR_COUNT_OVER);
        }
    }

    public static void checkName(String name){
        if(!name.matches(GameConstatns.CAR_NAME_REGEX)){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NAME_CHARACTER);
        }
        if(name.length() < GameConstatns.NAME_LENGTH_MIN){
            throw new IllegalArgumentException(ExceptionMessage.NAME_LENGTH_UNDER);
        }
        if(name.length() > GameConstatns.NAME_LENGTH_MAX){
            throw new IllegalArgumentException(ExceptionMessage.NAME_LENGTH_OVER);
        }
    }

    public static void checkNameDuplication(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if(uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NAME);
        }
    }

}
