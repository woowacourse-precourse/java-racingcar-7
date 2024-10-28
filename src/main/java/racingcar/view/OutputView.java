package racingcar.view;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class OutputView {

    private static final String StartOutputMessage = "실행 결과";
    private static final String DELIMITER = ",";


    public static void startOutput() {
        System.out.println(StartOutputMessage);
    }

    public static void printCarRacingStatus(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(toStringCarResult(car));
        }
    }

    private static String toStringCarResult(Car car) {
        return car.getName().getName() + " : " + car.getDistance().toString();
    }

    public static void printWinnerCars(Cars cars) {
        System.out.println(toStringWinnerCars(cars));
    }

    public static String toStringWinnerCars(Cars cars) {
        StringBuilder winnerCars = new StringBuilder();

        winnerCars.append("최종 우승자 :");

        for (Car car : cars.getWinnerCars()) {
            winnerCars.append(" ");
            winnerCars.append(car.getName().getName());
            winnerCars.append(DELIMITER);
        }

        //마지막 구분자 삭제
        winnerCars.delete(winnerCars.length() - 1, winnerCars.length());

        return winnerCars.toString();
    }

}
