package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final RacingCarService racingCarService;
    private final RacingCarView racingCarView;

    public RacingCarController(RacingCarService racingCarService, RacingCarView racingCarView) {
        this.racingCarService = racingCarService;
        this.racingCarView = racingCarView;
    }

    public void run() {

        //TODO
        // 경주할 자동차 이름 입력
        // 시도할 횟수
        // 게임시작
        // 실행 결과
        // 우승자

        String carNames = racingCarView.getCarNames();
        Integer numberOfAttempts = racingCarView.getNumberOfAttempts();

        if (numberOfAttempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }

        List<Car> racingCars = racingCarService.splitAndInitializeRacingCars(carNames);

        System.out.println("실행 결과");
        for (int i = 0; i < numberOfAttempts; i++) {
            racingCarService.startRacingCarGame(racingCars);

            for (Car car : racingCars) {
                racingCarView.printRaceResults(car.getName(), "-".repeat(car.getDistance()));
            }
        }

        int maxDistance = 0;
        for (Car car : racingCars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }

        List<String> winnerCars = new ArrayList<>();
        for (Car car : racingCars) {
            if (car.getDistance() == maxDistance) {
                winnerCars.add(car.getName());
            }
        }

        String winners = String.join(", ", winnerCars);
        // TODO: 우승자가 한명일때는 쉽표가 없도록 구현
        racingCarView.printWinners(winners);
    }
}
