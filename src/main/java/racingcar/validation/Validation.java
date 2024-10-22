package racingcar.validation;

import racingcar.view.ErrorView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validation {
    private static int MAX_RACINGCAR_NAME_LENGTH = 5;

    public static void validateRacingcarNames(List<String> racingcarNames){
        hasNameDuplicate(racingcarNames);
    }

    private static void hasNameDuplicate(List<String> racingcarNames){
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

}
