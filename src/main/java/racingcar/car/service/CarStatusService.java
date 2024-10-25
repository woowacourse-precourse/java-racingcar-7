package racingcar.car.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.model.Car;
import racingcar.car.util.RandomNumberGenerator;
import racingcar.view.Output;

// 자동차의 상태 관련 로직을 처리하는 서비스
public class CarStatusService {
    private final RandomNumberGenerator randomNumberGenerator;
    private final Output output;


    public CarStatusService(RandomNumberGenerator randomNumberGenerator, Output output) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.output = output;
    }

    // 경주 시작 메서드
    public void startRace(List<Car> cars, int attemptCount) {
        System.out.println();
        System.out.println("실행결과");

        for (int i = 0; i < attemptCount; i++) {
            for (Car car : cars) {
                car.move(randomNumberGenerator.generateRandomNumber(0, 9));  // 각 자동차에 대해 이동 처리
            }
            output.printRaceResults(cars);  // 각 차수 결과 출력
        }
    }

    // 우승자 계산 메서드
    public List<Car> getWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());  // 최대 위치에 있는 자동차가 우승자
    }
}
