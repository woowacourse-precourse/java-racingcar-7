package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceController {
    public void runRace() throws IllegalArgumentException {
        // 입력 받기
        String[] carNames = InputView.getCarNames();
        validateCarNames(carNames);

        int raceRounds = InputView.getRaceRounds();
        validateRaceRounds(raceRounds);

        // 자동차 객체 생성
        List<Car> cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());

        // 경주 진행
        Race race = new Race(cars);
        for (int i = 0; i < raceRounds; i++) {
            race.race(1);  // 한 라운드마다 모든 자동차 전진 시도
            OutputView.printRaceResult(cars);  // 각 라운드 결과 출력
        }

        // 우승자 출력
        List<Car> winners = race.getWinners();
        OutputView.printWinners(winners);
    }

    private void validateCarNames(String[] carNames) throws IllegalArgumentException{
        for (String name : carNames) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
            }
            if (name.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에는 공백이 포함될 수 없습니다.");
            }
        }
    }

    private void validateRaceRounds(int raceRounds) throws IllegalArgumentException{
        if (raceRounds <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상의 값이어야 합니다.");
        }
    }
}
