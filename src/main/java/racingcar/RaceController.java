package racingcar;

import java.util.List;

public class RaceController {
    private List<Car> carList;

    public void addCars(List<String> racerNames) {
        carList = racerNames.stream()
                .map(Car::new)
                .toList();
    }

    public void moveCars(int trialCount) {
        for (Car car : carList) {
            car.move(trialCount);
            System.out.println(car);
        }
    }

    public void getResult() {
        int win = carList.stream()
                .mapToInt(Car::getMove)
                .max()
                .getAsInt();

        List<String> winners = carList.stream()
                .filter(car -> car.getMove() == win)
                .map(Car::getName)
                .toList();

        System.out.println("최종 우승자 : " + String.join(",", winners));
    }

    public void run() {
        List<String> racerNames = InputManager.getRacerNames();
        addCars(racerNames);
        int trialCount = InputManager.getTrialCount();
        moveCars(trialCount);
        getResult();
    }
}
