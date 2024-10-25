package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RaceService;
import racingcar.util.Converter;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {
    private final RaceService raceService = new RaceService();

    public void startRace() {
        // 자동차 이름 입력
        List<String> carNames = InputView.getCarNames();

        // Car 객체 리스트 생성
        List<Car> cars = Converter.createCars(carNames);

        // 라운드 수 입력 & 유효성 검증
        int rounds = Validator.rounds(InputView.getRounds());

        // 경주 진행
        OutputView.printStartResult();
        for (int i = 0; i < rounds; i++) {
            raceService.playRound(cars);
            OutputView.printRoundResult(cars);
        }

        // 최종 우승자 출력
        List<String> winners = raceService.getWinners(cars);
        OutputView.printWinners(winners);
    }
}
