package racingcar;


import static racingcar.CarCreator.createCar;
import static racingcar.InputHandler.getNames;
import static racingcar.InputHandler.getTryCount;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Race {

    public void start() {

        List<Car> cars = createCar(getNames());
        int tryCount = getTryCount();

        System.out.println("실행 결과");

        for (int i = 0; i < tryCount; i++) {
            for (Car currentCar : cars) {
                randomlyDecideToMove(currentCar);
                currentCar.showDistance();
            }
            System.out.print('\n');
        }

        List<String> winners = findWinners(cars);
        showFinalWinners(winners);

    }

    private static void showFinalWinners(List<String> winners) {
        String result = "최종 우승자 : " + String.join(", ", winners);
        System.out.print(result);
    }

    private static List<String> findWinners(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(car -> car.getDistance().size())
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance().size() == maxDistance)
                .map(Car::getName)
                .toList();
    }

    private static void randomlyDecideToMove(Car currentCar) {
        if (Randoms.pickNumberInRange(0, 9) <= 4) {
            currentCar.moveForward();
        }
    }

}
