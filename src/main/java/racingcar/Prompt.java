package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class Prompt {
    public static String input() {
        return Console.readLine();
    }

    public static int racingTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public static void resultPrint(String output) {
        System.out.println(output);
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