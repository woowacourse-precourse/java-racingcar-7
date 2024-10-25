package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Prompt {
    public static void input(RacingCarTrace racingCarTrace) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        var input = Console.readLine();
        IOPreprocessor.inputPreprocessing(input, racingCarTrace);
    }

    public static int racingTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount;
        try {
            tryCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
        System.out.println();
        return tryCount;
    }

    public static void resultPrint(List<RacingCar> biggestDistanceRacingCar) {
        var result = IOPreprocessor.resultPreprocessing(biggestDistanceRacingCar);
        System.out.print("최종 우승자 : " + result);
        Console.close();
    }

    public static void tracePrint(RacingCarTrace racingCarTrace) {
        System.out.print(IOPreprocessor.tracePreprocessing(racingCarTrace));
    }
}