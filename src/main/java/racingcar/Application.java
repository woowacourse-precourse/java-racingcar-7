package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.factory.StringParserFactory;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        String inputCarName = Console.readLine();
        String inputLoopCount = Console.readLine();

        StringParserFactory stringParserFactory = new StringParserFactory();
        List<String> carNameList = stringParserFactory.parseCarName(inputCarName);
        int loopCount = stringParserFactory.parseLoopCount(inputLoopCount);
    }
}
