package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingGame;

public class RacingGameService {
    private RacingGame racingGame;

    public void startGame(String carNames, String rounds) {
        int parsedRounds = initializeGame(carNames, rounds);
        racingGame = new RacingGame(createCars(carNames), parsedRounds);
    }

    private int initializeGame(String carNames, String rounds) {
        validateCarNames(carNames);
        int parsedRounds = parseRounds(rounds);
        validateRounds(parsedRounds);
        return parsedRounds;
    }

    public void playRound() {
        racingGame.playRound();
    }

    public boolean hasNextRound() {
        return racingGame.hasNextRound();
    }

    public List<Car> getCurrentStatus() {
        return racingGame.getCars();
    }

    public List<String> getWinners() {
        return racingGame.getWinners();
    }

    private void validateCarNames(String carNames) {
        String[] carNameArray = carNames.split(",");
        for (String carName : carNameArray) {
            String trimmedName = carName.trim();
            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            } else if (trimmedName.length() <= 0) {
                throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
            }
        }
    }

    private int parseRounds(String rounds) {
        try {
            return Integer.parseInt(rounds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("경기 횟수는 숫자로 입력해야 합니다.");
        }
    }

    private void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("경기 횟수는 1 이상이어야 합니다.");
        }
    }

    private List<Car> createCars(String carNames) {
        String[] carNameArray = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String carName : carNameArray) {
            cars.add(new Car(carName.trim()));
        }
        return cars;
    }
}
