package input;

import camp.nextstep.edu.missionutils.Console;
import delimiter.InputDelimiter;
import java.util.List;

public class CarName {
    InputDelimiter inputDelimiter = new InputDelimiter();

    public List<String> inputHandler() {
        String inputCarNameLump = inputCarName();

        return inputDelimiter.delimiterWithComma(inputCarNameLump);
    }

    private String inputCarName() {
        // 원시값 포장 필요
        String carName = Console.readLine();

        return carName;
    }
}
