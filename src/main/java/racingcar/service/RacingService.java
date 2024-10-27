package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.controller.CarDTO;
import racingcar.controller.RaceResultDTO;
import racingcar.domain.Car;

public class RacingService {

    public RaceResultDTO startRace(String[] carNames, int trialCount) {
        List<Car> cars = createCarsByName(carNames, trialCount);

        Map<Integer, List<CarDTO>> raceProcedure = getRaceProcedure(trialCount, cars);

        List<String> winners = getRaceWinners(cars);

        return new RaceResultDTO(winners, raceProcedure);
    }

    private Map<Integer, List<CarDTO>> getRaceProcedure(int trialCount, List<Car> cars) {
        Map<Integer, List<CarDTO>> raceProcedure = new HashMap<>();

        for (int i = 1; i <= trialCount; i++) {
            runRace(cars);
            raceProcedure.put(i, createCarDTOs(cars));
        }
        return raceProcedure;
    }

    private List<Car> createCarsByName(String[] carNames, int trialCount) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, trialCount));
        }
        return cars;
    }

    private void runRace(List<Car> cars) {
        for (Car car : cars) {
            if (isMovingForward()) {
                car.forward();
            } else {
                car.stop();
            }
        }
    }

    private boolean isMovingForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    private List<CarDTO> createCarDTOs(List<Car> cars) {
        return cars.stream()
                .map(car -> new CarDTO(car.getName(), car.getLocation()))
                .toList();
    }

    private List<String> getRaceWinners(List<Car> cars) {
        int maxLocation = cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .toList();
    }
}