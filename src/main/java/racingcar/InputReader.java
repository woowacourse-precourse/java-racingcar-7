package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputReader {
    public String readCarNames() throws NoSuchElementException{
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        validateInput(userInput);
        return userInput;
    }
    public int readNumberOfTrial() throws NoSuchElementException{
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        return Integer.parseInt(userInput);
    }
    private static Pattern pattern = Pattern.compile("[A-Za-z][A-Za-z0-9]{0,4}");
    private void validateInput(String userInput) throws IllegalArgumentException{
        for(String name : userInput.split(",")){
            Matcher matcher = pattern.matcher(name.trim());
            if(!matcher.matches())
                throw new IllegalArgumentException("이름이 형식에 맞지 않습니다.");
        }
    }
}
