package racingcar;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputReader {
    ValidationCheck validationCheck = new ValidationCheck();
    public String readCarNames(){
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        validationCheck.validateCarName(userInput);
        return userInput;
    }
    public int readNumberOfTrial(){
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        validationCheck.validateNumberOfTrial(userInput);
        return Integer.parseInt(userInput);
    }
}
