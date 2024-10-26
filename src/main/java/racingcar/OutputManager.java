package racingcar;

import java.util.List;

public class OutputManager {

    private static final String ROUND_RESULT = "실행 결과";
    private static final String WINNER_RESULT = "최종 우승자 : ";

    public static void printStartMessage() {
        System.out.println();
        System.out.println(ROUND_RESULT);
    }

    public static void printCurrent(Car car) {
        System.out.println(car.printStatus());;
    }

    public static void printWinner(List<Car> winnerNames) {
        System.out.print(WINNER_RESULT);
        StringBuilder sb = new StringBuilder();

        int i = 0;

        for (int idx = i; idx < winnerNames.size() - 1; idx++){
            sb.append(winnerNames.get(idx));
            sb.append(", ");
            i++;
        }

        sb.append(winnerNames.get(i));
        System.out.println(sb);
    }
}
