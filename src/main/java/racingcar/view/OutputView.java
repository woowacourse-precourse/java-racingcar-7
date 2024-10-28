package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public void printRoundResult(List<Car> cars) {

        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            sb.append(car.getName()).append(" : ");
            sb.append("-".repeat(car.getPosition())).append("\n");
        }

        System.out.println(sb);

    }

    public void printWinner(List<Car> cars) {
        StringBuilder sb = new StringBuilder();

        sb.append("최종 우승자 : ");

        for (int i = 0; i < cars.size(); i++) {
            sb.append(cars.get(i).getName());
            if (i != cars.size() - 1) {
                sb.append(", ");
            }
        }

        System.out.println(sb);
    }
}
