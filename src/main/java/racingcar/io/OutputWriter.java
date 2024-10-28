package racingcar.io;

import racingcar.domain.Car;

import java.util.Collections;
import java.util.List;

public class OutputWriter {

    private final StringBuilder stringBuilder = new StringBuilder();

    public void printResultStart() {
        System.out.println("\n실행 결과");
    }

    public void printIntermediateResult(List<Car> cars) {
        for (Car car : cars) {
            stringBuilder.append(car.toString()).append("\n");
        }
        stringBuilder.append("\n");

        System.out.print(stringBuilder);
        stringBuilder.setLength(0);
    }

    public void printFinalResult(List<Car> cars) {
        stringBuilder.append("최종 우승자 : ");

        Collections.sort(cars);
        stringBuilder.append(cars.getFirst().getName());
        int maxMoveCount = cars.getFirst().getMoveCount();

        int idx = 1;
        while (idx < cars.size()) {
            if (cars.get(idx).getMoveCount() != maxMoveCount) {
                break;
            }
            stringBuilder.append(", ").append(cars.get(idx).getName());
            idx++;
        }

        System.out.print(stringBuilder);
    }
}
