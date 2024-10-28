package racingcar;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputReader {
    ValidationCheck validationCheck = new ValidationCheck();
    public String readCarNames(){
        try {
            String userInput = camp.nextstep.edu.missionutils.Console.readLine();
            validationCheck.validateCarName(userInput);
            return userInput;
        }
        catch(NoSuchElementException e){
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }
    public int readNumberOfTrial(){
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        validationCheck.validateNumberOfTrial(userInput);
        return Integer.parseInt(userInput);
    }
}
