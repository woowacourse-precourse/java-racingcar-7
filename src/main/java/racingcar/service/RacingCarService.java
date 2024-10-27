package racingcar.service;

import racingcar.domain.Car;
import racingcar.dto.request.RaceRequest;
import racingcar.dto.request.RacingCarRequest;
import racingcar.dto.request.RoundRequest;
import racingcar.util.CarNameValidator;
import racingcar.util.RoundValidator;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCarService {

    private final CarNameValidator carNameValidator;
    private final RoundValidator roundValidator;
    private final OutputView outputView;

    private String[] carList;

    public RacingCarService() {
        this.carNameValidator = new CarNameValidator();
        this.roundValidator = new RoundValidator();
        this.outputView = new OutputView();

    }

    public String[] validateCarNames(String carNames) {
        carList = carNames.split(",");

        for (int i = 0; i < carList.length; i++){
            carList[i] = carList[i].strip();
        }

        return carNameValidator.validate(carList);
    }

    public List<Car> setRacingCars(RacingCarRequest request) {
        validateCarNames(request.carNames());

        List<Car> cars = new ArrayList<>();

        for (String name : carList) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public int setRound(RoundRequest request) {
        String round = roundValidator.validate(request.round());
        return Integer.parseInt(round);
    }

    public List<String> startRace(RaceRequest request) {
        List<Car> racingCars = request.racingCars();
        int roundNum = request.roundNum();

        IntStream.range(0, roundNum).forEach(i -> {
            racingCars.forEach(Car::move);
            outputView.printRaceMessage(racingCars);  // 각 라운드 후에 출력
        });

        return getWinners(racingCars);
    }

    private List<String> getWinners(List<Car> racingCars) {
        int maxPosition = racingCars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }
}