package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class WoowaUserInput implements UserInputHandler {
    @Override
    public List<String> makeUserInputNames() {
        ParserUserInput parserUserInput = new ParserUserInput();
        String makeString = Console.readLine();
        parserUserInput.hasOnlyCharacters(makeString);
        return parserUserInput.split(makeString);
    }

    @Override
    public int makeUserInputRoundNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
