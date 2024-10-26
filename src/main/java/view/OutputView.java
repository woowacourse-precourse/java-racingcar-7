package view;

import java.util.List;
import java.util.stream.Collectors;
import model.Car;

public class OutputView {

    private final static char RACE_STEP = '-';

    public void showRaceStart() {
        System.out.println("실행 결과");
    }

    // TODO: view에서 car에 접근하는건 별로 인듯?
    public void showRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            showCarName(car);
            showCarStep(car);
        }
        System.out.println();
    }

    public void showWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.print("최종 우승자 : " + winnerNames);
    }

    private void showCarName(Car car) {
        System.out.print(car.getName() + " : ");
    }

    private void showCarStep(Car car) {
        for (int i = 0; i < car.getStep(); i++) {
            System.out.print(RACE_STEP);
        }
        System.out.println();
    }

}
