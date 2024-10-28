package racingcar.view;

import racingcar.domain.Car;

public class Output {
    public static final String forwardDelimiter = "-";
    private static boolean isFirstOutput = true;

    public static void gameResult(Car[] player) {
        if (isFirstOutput) {
            System.out.println("\n실행 결과");
            isFirstOutput = false;
        }
        for (Car car : player) {
            System.out.print(car.getCarName() + " : ");
            System.out.println(forwardDelimiter.repeat(car.getForwardCount()));
        }
        System.out.println();
    }

    public static void gameWinners(String gameWinners) {
        System.out.print("최종 우승자 : " + gameWinners);
    }
}
