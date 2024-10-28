package racingcar;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class InputReader {
    public String readCarNames(){
        try {
            String userInput = camp.nextstep.edu.missionutils.Console.readLine();
            return userInput;
        }
        catch(NoSuchElementException e){
            throw new NoSuchElementException("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        }
    }
    public int readNumberOfTrial(){
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        return Integer.parseInt(userInput);
    }
}
