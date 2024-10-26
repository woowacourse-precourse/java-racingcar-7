package racingcar.validation;

import racingcar.utils.Utils;
import racingcar.view.ErrorView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validation {
    private static final String NONE_INPUT_STRING = "";

    private static int MAX_RACINGCAR_NAME_LENGTH = 5;

    public static void validateRacingcarNamesDuplicate(List<String> racingcarNames){
        if(hasDuplicates(racingcarNames)){
            ErrorView.printRacingcarDuplicateNameErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    private static <T> boolean hasDuplicates(List<T> targetList){
        Set<T> set = Utils.listToSet(targetList);
        return set.size() != targetList.size();
    }

    public static void validateRacingcarName(String racingcarName){
        validateRacingcarNameBlank(racingcarName);
        validateRacingcarNameLength(racingcarName);
    }

    private static void validateRacingcarNameBlank(String racingcarName){
        if(isBlankOrNull(racingcarName)){
            ErrorView.printRacingcarBlankNameErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    private static boolean isBlankOrNull(String target){
        return target == null || target.trim().isEmpty();
    }

    private static void validateRacingcarNameLength(String racingcarName){
        if(isNameLengthExceedingLimit(racingcarName)){
            ErrorView.printRacingcarLengthErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNameLengthExceedingLimit(String racingcarName){
        return racingcarName.length() > MAX_RACINGCAR_NAME_LENGTH;
    }

    public static void validateRacingGameRoundCount(int racingGameCount){
        if(isInvalidRoundCount(racingGameCount)){
            ErrorView.printRacingGameCountErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInvalidRoundCount(int racingGameCount){
        return racingGameCount <= 0;
    }

    public static void validateStringToInteger(String input){
        if(isNotNumeric(input)){
            ErrorView.printRacingGameCountErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNotNumeric(String target){
        return !target.chars().allMatch(Character::isDigit) || target.equals(NONE_INPUT_STRING);
    }

}
