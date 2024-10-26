package racingcar.view;

import java.util.List;
import racingcar.Car;

public class OutputView {

    public void printRoundHeader() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();

        cars.forEach(car -> {
            stringBuilder.append(car.getName());
            stringBuilder.append(" : ");
            for (int i = 0; i < car.getPosition(); i++) {
                stringBuilder.append("-");
            }
            stringBuilder.append("\n");
        });

        System.out.println(stringBuilder);
    }

    public void printWinner(List<Car> winners) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("최종 우승자 : ");

        for (int i = 0; i < winners.size(); i++) {
            stringBuilder.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                stringBuilder.append(", ");
            }
        }

        System.out.println(stringBuilder);
    }
}
