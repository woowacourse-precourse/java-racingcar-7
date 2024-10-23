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
        List<String> racingCarName = biggestDistanceRacingCar.stream().map(RacingCar::name).toList();
        String result = String.join(",", racingCarName);
        System.out.println("최종 우승자 : " + result);
        Console.close();
    }

    public static void tracePrint(RacingCarTrace racingCarTrace) {
        for (int i = 0; i < racingCarTrace.size(); i++) {
            RacingCar racingCar = racingCarTrace.getRacingCar(i);
            System.out.print(racingCar.name() + " : ");
            for (int j = 0; j < racingCarTrace.getDistance(racingCar); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}