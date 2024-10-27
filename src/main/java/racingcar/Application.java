package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Racing;
import racingcar.factory.StringParserFactory;

import java.util.HashMap;
import java.util.List;

import static racingcar.common.Symbol.NEW_LINE;
import static racingcar.common.Symbol.RESULT;

public class Application {
    public static void main(String[] args) {

        String inputCarName = Console.readLine();
        String inputLoopCount = Console.readLine();

        StringParserFactory stringParserFactory = new StringParserFactory();
        List<String> carNameList = stringParserFactory.parseCarName(inputCarName);
        int loopCount = stringParserFactory.parseLoopCount(inputLoopCount);

        Racing racing = new Racing();
        HashMap<String, StringBuilder> racingLog = new HashMap<>();
        initRacingLog(racingLog, carNameList);

        for (int i = 0; i < loopCount; i++) {
            racing.start(racingLog, carNameList);
            printRacingResult(racingLog, carNameList);
        }
    }

    private static void initRacingLog(HashMap<String, StringBuilder> racingLog, List<String> carNameList) {
        for (String carName : carNameList) {
            racingLog.put(carName, new StringBuilder());
        }
    }

    private static void printRacingResult(HashMap<String, StringBuilder> racingLog, List<String> carNameList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String carName : carNameList) {
            stringBuilder.append(carName + RESULT + racingLog.get(carName) + NEW_LINE);
        }
        System.out.println(stringBuilder);
    }
}
