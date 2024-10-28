package racingcar.race.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.model.Car;
import racingcar.car.service.CarNameService;

import racingcar.car.util.RandomNumberGenerator;
import racingcar.view.Output;

public class RaceService {

    private static final String RACE_RESULT_MESSAGE = "실행결과";

    private final CarNameService carNameService;
    private final RandomNumberGenerator randomNumberGenerator;
    private final Output output;
    private List<Car> cars;

    public RaceService(CarNameService carNameService, RandomNumberGenerator randomNumberGenerator, Output output) {
        this.carNameService = carNameService;
        this.randomNumberGenerator = randomNumberGenerator;
        this.output = output;
    }

    // 경주 시작 메서드
    public void startRace(List<String> carNames, String attemptCountInput) {

        // 경주 시작 로직
        long attemptCount = Long.parseLong(attemptCountInput);
        cars = carNameService.createCars(carNames);
        System.out.println();
        System.out.println(RACE_RESULT_MESSAGE);

        for (int i = 0; i < attemptCount; i++) {
            cars = cars.stream().map(car -> car.move(randomNumberGenerator.generateRandomNumber()))
                    .collect(Collectors.toList());  // 새로운 자동차 리스트로 갱신
            output.printRaceResults(cars);
        }
    }

    // 우승자 리스트를 반환하는 메서드
    public List<Car> getWinners() {
        int maxPosition = findMaxPosition();  // 최대 위치 계산
        return collectWinners(maxPosition);   // 최대 위치에 있는 우승자들 수집
    }

    // 최대 위치 찾기
    private int findMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(Integer.MIN_VALUE);  // 최소값을 초기값으로 설정
    }

    // 최대 위치에 해당하는 우승자 리스트 수집
    private List<Car> collectWinners(int maxPosition) {
        return cars.stream().filter(car -> car.getPosition() == maxPosition) // 최대 위치에 있는 자동차 필터링
                .collect(Collectors.toList());  // 우승자 리스트 반환
    }
}