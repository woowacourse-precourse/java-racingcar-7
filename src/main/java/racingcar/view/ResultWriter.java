package racingcar.view;

import racingcar.Cars;

public class ResultWriter {

    public void writeResultStart() {
        System.out.println("\n실행 결과");
    }

    public void writeResult(Cars cars) {
        cars.getCars().forEach(System.out::println);
        System.out.println();
    }
}
