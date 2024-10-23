package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Prompt {
    public static void input(RacingCarTrace racingCarTrace) {
        String input = Console.readLine();
        IOPreprocessor.inputPreprocessing(input, racingCarTrace);
    }

    public static int racingTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public static void resultPrint(List<RacingCar> biggestDistanceRacingCar) {
        String result = IOPreprocessor.resultPreprocessing(biggestDistanceRacingCar);
        System.out.println("최종 우승자 : " + result);
        Console.close();
    }

    public static void tracePrint(RacingCarTrace racingCarTrace) {
        System.out.print(IOPreprocessor.tracePreprocessing(racingCarTrace));
    }
}