package racingcar;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class InputReader {
    public String readCarNames() throws NoSuchElementException{
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        return userInput;
    }
    public int readNumberOfTrial() throws NoSuchElementException{
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        return Integer.parseInt(userInput);
    }

}
