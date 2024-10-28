package racingcar.race.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.model.Car;
import racingcar.car.service.CarNameService;

import racingcar.car.util.RandomNumberGenerator;
import racingcar.race.validation.AttemptCountValidator;
import racingcar.view.Output;


// 경주 로직을 처리하는 서비스
public class RaceService {

    private static final String RACE_RESULT_MESSAGE = "실행결과";

    private final CarNameService carNameService;
    private final RandomNumberGenerator randomNumberGenerator;
    private final AttemptCountValidator attemptCountValidator;
    private final Output output;
    private List<Car> cars;

    public RaceService(CarNameService carNameService, RandomNumberGenerator randomNumberGenerator, Output output, AttemptCountValidator attemptCountValidator) {
        this.carNameService = carNameService;
        this.randomNumberGenerator = randomNumberGenerator;
        this.output = output;
        this.attemptCountValidator = attemptCountValidator;
    }

    // 경주 시작 메서드
    public void startRace(List<String> carNames, String attemptCountInput) {
        // 시도 횟수 검증
        attemptCountValidator.validateAttemptCount(attemptCountInput);

        // 경주 시작 로직
        int attemptCount = Integer.parseInt(attemptCountInput);
        cars = carNameService.createCars(carNames);
        System.out.println();
        System.out.println(RACE_RESULT_MESSAGE);
        for (int i = 0; i < attemptCount; i++) {
            cars = cars.stream()
                    .map(car -> car.move(randomNumberGenerator.generateRandomNumber()))
                    .collect(Collectors.toList());  // 불변 객체 리스트 갱신
            output.printRaceResults(cars);
        }
    }

    // 우승자를 계산
//    public List<Car> getWinners() {
//        int maxPosition = Integer.MIN_VALUE;
//        List<Car> winners = new ArrayList<>();
//        for (Car car : cars) {
//            if (car.getPosition() > maxPosition) {
//                maxPosition = car.getPosition();
//                winners.clear();
//                winners.add(car);
//            } else if (car.getPosition() == maxPosition) {
//                winners.add(car);
//            }
//        }
//        return winners;
//    }
    public List<Car> getWinners() {
        int maxPosition = findMaxPosition();  // 최대 위치 계산
        return collectWinners(maxPosition);   // 최대 위치에 있는 우승자들 수집
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Integer.MIN_VALUE);  // 최소값을 초기값으로 설정
    }

    private List<Car> collectWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());  // 우승자 목록 반환
    }


}