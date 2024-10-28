package racingcar.util;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static racingcar.constant.ErrorMessage.*;

public class Validator {

    public void checkCarNameInput(String input){
        String[] carNames = input.split(",");
        Set<String> carNameSet = new HashSet<>();
        for (String carName : carNames){
            if (carNameSet.contains(carName)){
                throw new IllegalArgumentException(DUPLICATE_CARNAME_EXCEPTION.getMessage() + carName);
            }
            if (carName.isEmpty()){
                throw new IllegalArgumentException(CARNAME_BLANK_EXCEPTION.getMessage());
            }
            if (carName.length() > 5){
                throw new IllegalArgumentException(CARNAME_LENGTH_EXCEPTION.getMessage() + carName);
            }
            carNameSet.add(carName);
        }
    }

    public void checkAttemptInput(String input) {
        String regex = "[0-9]+";
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(ATTEMPTS_FORMAT_EXCEPTION.getMessage() + input);
        }
    }
}
