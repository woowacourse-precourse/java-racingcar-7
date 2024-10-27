package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Racing;
import racingcar.domain.WinnerDeterminer;
import racingcar.factory.StringParserFactory;

import java.util.HashMap;
import java.util.List;

import static racingcar.common.Symbol.*;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputLoopCount = Console.readLine();
        System.out.println();

        StringParserFactory stringParserFactory = new StringParserFactory();

        List<String> carNameList = stringParserFactory.parseCarName(inputCarName);
        int loopCount = stringParserFactory.parseLoopCount(inputLoopCount);

        Racing racing = new Racing();

        HashMap<String, Integer> racingLog = new HashMap<>();
        initRacingLog(racingLog, carNameList);
        System.out.println("실행 결과");
        for (int i = 0; i < loopCount; i++) {
            racing.start(racingLog, carNameList);
            printRacingResult(racingLog, carNameList);
        }

        WinnerDeterminer winnerDeterminer = new WinnerDeterminer();

        List<String> winner = winnerDeterminer.determineWinner(racingLog, carNameList);
        printWinner(winner);
    }

    private static void initRacingLog(HashMap<String, Integer> racingLog, List<String> carNameList) {
        for (String carName : carNameList) {
            racingLog.put(carName, 0);
        }
    }

    private static void printRacingResult(HashMap<String, Integer> racingLog, List<String> carNameList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String carName : carNameList) {
            String moveCount = HYPHEN.repeat(racingLog.get(carName));
            stringBuilder.append(carName + RESULT + moveCount + NEW_LINE);
        }
        System.out.println(stringBuilder);
    }

    private static void printWinner(List<String> winner) {
        if (winner == null) {
            System.out.println("우승자가 존재하지 않습니다.");
            return;
        }
        System.out.println("최종 우승자 : " + String.join(COMMA + SPACE, winner));
    }
}
