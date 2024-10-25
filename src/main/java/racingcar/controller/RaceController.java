package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RaceService;
import racingcar.util.Converter;
import racingcar.view.InputView;

import java.util.List;

public class RaceController {
    private final RaceService raceService = new RaceService();

    public void startRace() {
        // 자동차 이름 입력
        List<String> carNames = InputView.getCarNames();

        // Car 객체 리스트 생성
        List<Car> cars = Converter.createCars(carNames);

        // 라운드 수 입력
        int rounds = Integer.parseInt(InputView.getRounds());

        // 경주 진행
        for (int i = 0; i < rounds; i++) {
            raceService.playRound(cars);
        }
    }
}
