package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceController {
    private final int defaultRound = 1;
    private final int defualtMinRound = 0;

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
            race.race(defaultRound);  // 한 라운드마다 모든 자동차 전진
            OutputView.printRaceResult(cars);
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

        // 중복 이름 검사
        long distinctCount = Arrays.stream(carNames).distinct().count();
        if (distinctCount < carNames.length) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private void validateRaceRounds(int raceRounds) throws IllegalArgumentException{
        if (raceRounds <= defualtMinRound) {
            throw new IllegalArgumentException(String.format("시도할 횟수는 %d 이상의 값이어야 합니다.", defualtMinRound));
        }
    }
}
