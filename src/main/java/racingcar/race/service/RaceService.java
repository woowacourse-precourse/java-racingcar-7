package racingcar.race.service;

import java.util.List;
import racingcar.car.model.Car;
import racingcar.car.service.CarNameService;
import racingcar.car.service.CarStatusService;
import racingcar.view.Input;
import racingcar.view.Output;


// 경주 로직을 처리하는 서비스
public class RaceService {
    private final CarNameService carNameService;
    private final CarStatusService carStatusService;
    private List<Car> cars;

    public RaceService(CarNameService carNameService, CarStatusService carStatusService, Input input, Output output) {
        this.carNameService = carNameService;
        this.carStatusService = carStatusService;
    }

    // 경주 시작 메서드
    public void startRace(List<String> carNames, int attemptCount) {
        cars = carNameService.createCars(carNames);  // 자동차 생성
        carStatusService.startRace(cars, attemptCount);  // 경주 시작
    }

    // 우승자를 계산
    public List<Car> getWinners() {
        return carStatusService.getWinners(cars);  // 우승자 반환
    }
}