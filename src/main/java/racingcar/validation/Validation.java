package racingcar.validation;

import racingcar.view.ErrorView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validation {
    private static final String NONE_INPUT_STRING = "";

    private static int MAX_RACINGCAR_NAME_LENGTH = 5;

    public static void validateRacingcarNamesDuplicate(List<String> racingcarNames){
        Set<String> setRacingcarNames = racingcarNames.stream()
                .collect(Collectors.toSet());
        if(setRacingcarNames.size() != racingcarNames.size()){
            ErrorView.printRacingcarDuplicateNameErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateRacingcarName(String racingcarName){
        validateRacingcarNameBlank(racingcarName);
        validateRacingcarNameLength(racingcarName);
    }

    private static void validateRacingcarNameBlank(String racingcarName){
        if(racingcarName == null || racingcarName.trim().isEmpty()){
            ErrorView.printRacingcarBlankNameErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    private static void validateRacingcarNameLength(String racingcarName){
        if(racingcarName.length() > MAX_RACINGCAR_NAME_LENGTH){
            ErrorView.printRacingcarLengthErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateRacingGameRoundCount(int racingGameCount){
        if(racingGameCount <= 0){
            ErrorView.printRacingGameCountErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    public static void validateStringToInteger(String input){
        if(!input.chars().allMatch(Character::isDigit) || input.equals(NONE_INPUT_STRING)){
            ErrorView.printRacingGameCountErrorMessage();
            throw new IllegalArgumentException();
        }
    }

}
