package racingcar.view;

import java.util.List;
import racingcar.car.Cars;

public class ResultWriter {

    public void writeResultStart() {
        System.out.println("\n실행 결과");
    }

    public void writeResult(Cars cars) {
        cars.getCars().forEach(System.out::println);
        System.out.println();
    }

    public void writeWinners(final List<String> names) {
        System.out.println("최종 우승자 : " + String.join(", ", names));
    }
}
