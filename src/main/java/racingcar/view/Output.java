package racingcar.view;

import racingcar.domain.Car;

public class Output {
    public static final String forwardDelimiter = "-";
    private static boolean isFirstOutput = true;

    public static void gameResult(Car[] player) {
        if(isFirstOutput) {
            System.out.println("\n실행 결과");
            isFirstOutput = false;
        }
        for (Car car : player) {
            System.out.print(car.getCarName() + " : ");
            System.out.println(forwardDelimiter.repeat(car.getForwardCount()));
        }
        System.out.println();
    }

    public static void gameWinners(int max, Car[] participants) {
        System.out.print("최종 우승자 : ");
        int count = 0;
        for (Car participant : participants) {
            if (count == 0 && participant.getForwardCount() == max) {
                System.out.print(participant.getCarName());
                count++;
            } else if (count >= 1 && participant.getForwardCount() == max) {
                System.out.print(", " + participant.getCarName());
            }
        }

    }
}
