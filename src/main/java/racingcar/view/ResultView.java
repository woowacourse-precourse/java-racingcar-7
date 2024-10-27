package racingcar.view;

import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class ResultView {
    public ResultView() {

    }

    public void printResult() {
        System.out.println("\n실행 결과");
    }

    public void printAllLocations(Cars cars) {
        for (Car car : cars.getCars()) {
            printEachLocation(car);
        }
        System.out.println();
    }

    public void printEachLocation(Car car) {
        System.out.println(car.getName() + " : " + stringLocation(car.getLocation()));
    }

    private String stringLocation(int location) {
        StringBuilder sbLocation = new StringBuilder();
        IntStream.rangeClosed(1, location)
                .forEach(i -> sbLocation.append("-"));
        return sbLocation.toString();
    }

    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
