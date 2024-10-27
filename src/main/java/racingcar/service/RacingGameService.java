package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.constant.Movement;
import racingcar.model.RacingCar;
import racingcar.model.RacingGame;

public class RacingGameService {
    public static final int MIN_RANDOM_VALUE = 0;
    public static final int MAX_RANDOM_VALUE = 9;
    private static final int FORWARD_THRESHOLD = 4;

    // 경주 초기화: 자동차 이름 목록과 시도 횟수를 받아 RacingGame 객체 생성
    public RacingGame initializeRace(List<String> carNames, int attempts) {
        List<RacingCar> cars = RacingCar.createRacingCars(carNames);
        return new RacingGame(cars, attempts);
    }

    // 경주 실행: 각 라운드별로 자동차 이동을 시도하고, 각 라운드의 결과를 기록하여 반환
    public List<Map<String, Integer>> runRace(RacingGame racingGame) {
        List<Map<String, Integer>> raceHistory = new ArrayList<>();

        for (int i = 0; i < racingGame.attempts(); i++) {
            raceRound(racingGame.cars());
            raceHistory.add(getCurrentLocations(racingGame.cars()));
        }
        return raceHistory;
    }

    // 각 라운드에서 자동차를 이동시키는 메서드
    private void raceRound(List<RacingCar> cars) {
        cars.forEach(car -> {
            int randomValue = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
            Movement movement = determineMovement(randomValue);
            car.move(movement);
        });
    }

    // 이동 상태 결정
    private Movement determineMovement(int randomNumber) {
        if (randomNumber >= FORWARD_THRESHOLD) {
            return Movement.FORWARD;
        } else {
            return Movement.STOP;
        }
    }

    private Map<String, Integer> getCurrentLocations(List<RacingCar> cars) {
        return cars.stream()
                .collect(Collectors.toMap(
                        RacingCar::getName, RacingCar::getLocation
                ));
    }

    public List<String> getWinners(List<RacingCar> cars) {
        int maxLocation = cars.stream()
                .mapToInt(RacingCar::getLocation)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(RacingCar::getName)
                .toList();
    }
}