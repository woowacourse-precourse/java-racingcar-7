package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.factory.StringParserFactory;

public class Application {
    public static void main(String[] args) {

        String inputCarName = Console.readLine();
        String inputLoopCount = Console.readLine();

        StringParserFactory stringParserFactory = new StringParserFactory();
        stringParserFactory.parseCarName(inputCarName);
        stringParserFactory.parseLoopCount(inputLoopCount);
    }
}
