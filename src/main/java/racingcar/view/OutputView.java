package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String ROUND_RESULT_HEADER = "실행 결과";
    private static final String WINNER_HEADER = "최종 우승자 : ";

    public void printRoundHeader() {
        System.out.println(ROUND_RESULT_HEADER);
    }

    public void printRoundResult(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();

        cars.forEach(car -> {
            stringBuilder.append(car.getName());
            stringBuilder.append(" : ");
            stringBuilder.append("-".repeat(Math.max(0, car.getPosition())));
            stringBuilder.append("\n");
        });

        System.out.println(stringBuilder);
    }

    public void printWinner(List<Car> winners) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(WINNER_HEADER);

        for (int i = 0; i < winners.size(); i++) {
            stringBuilder.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                stringBuilder.append(", ");
            }
        }

        System.out.println(stringBuilder);
    }
}
