package racingcar.io;

import java.util.List;
import racingcar.car.Car;

public class OutputManager {

    private static final String ROUND_RESULT = "실행 결과";
    private static final String WINNER_RESULT = "최종 우승자 : ";
    private static final String COMMA_WITH_BLANK = ", ";

    public static void printStartMessage() {
        System.out.println();
        System.out.println(ROUND_RESULT);
    }

    public static void printCurrent(Car car) {
        System.out.println(car.getRaceStatus());
    }

    public static void printWinner(List<Car> winners) {
        System.out.print(WINNER_RESULT);
        StringBuilder sb = new StringBuilder();

        int i = 0;

        for (int idx = i; idx < winners.size() - 1; idx++){
            sb.append(winners.get(idx));
            sb.append(COMMA_WITH_BLANK);
            i++;
        }

        sb.append(winners.get(i));
        System.out.println(sb);
        System.out.println();
    }
}
