package racingcar.runner;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.runner.dto.CarDto;

import java.util.*;

public class RacingCar {

    private final String carString;
    private final String roundString;

    private List<CarDto> cars;
    private int rounds;

    public RacingCar(String carString, String roundString) {
        this.carString = carString;
        this.roundString = roundString;
    }

    public String run() {
        this.validateInputStrings();
        return String.join(", ", this.getWinners());
    }

    private List<String> getWinners() {
        this.start();
        return cars.stream()
            .filter(car -> car.getMovementStatus() == this.getMaxMovement())
            .map(CarDto::getCarName)
            .toList();
    }

    private void start() {
        System.out.println("실행 결과");
        for (int i = 0; i < rounds; i++) {
            for (CarDto car : cars) {
                this.updateMovementStatusByCar(car);
            }
            System.out.println();
        }
    }

    private void updateMovementStatusByCar(CarDto car) {
        int movementStatus = car.getMovementStatus() + this.getMovingStatus();
        car.setMovementStatus(movementStatus);
        this.printRoundResult(car);
    }

    private int getMovingStatus() {
        int minForMovingForward = 4;
        int random = Randoms.pickNumberInRange(0, 9);

        if (random < minForMovingForward) {
            return 0;
        }

        return 1;
    }

    private void printRoundResult(CarDto car) {
        System.out.printf("%s : %s%n", car.getCarName(), "-".repeat(car.getMovementStatus()));
    }

    private int getMaxMovement() {
        return cars.stream()
            .max(Comparator.comparingInt(CarDto::getMovementStatus))
            .map(CarDto::getMovementStatus)
            .orElse(0);
    }

    private void validateInputStrings() {
        this.validateCarString();
        this.validateRoundString();
    }

    private void validateRoundString() {
        try {
            rounds = Integer.parseInt(roundString);
            if (rounds < 1) {
                throw new IllegalArgumentException("시도 횟수가 적절하지 않습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.", e);
        }
    }

    private void validateCarString() {
        cars = Arrays.stream(carString.split(","))
            .map(car -> this.createCarIfValid(car.trim()))
            .toList();
        this.validateDuplication();
    }

    private CarDto createCarIfValid(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("빈 이름은 허용되지 않습니다.");
        }

        if (this.isValidCarName(carName)) {
            throw new IllegalArgumentException("자동차 이름은 영문, 한글, 숫자로 이루어진 5자 이하의 문자열만 허용됩니다.");
        }

        return new CarDto(carName, 0);
    }

    private boolean isValidCarName(String carName) {
        String regex = "^[a-zA-Z0-9가-힣 ]{1,5}$";    // 5자 이하, 영문, 한글, 숫자, 공백 포함
        return !carName.matches(regex);
    }

    private void validateDuplication() {
        List<String> carNames = cars.stream().map(CarDto::getCarName).toList();
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 허용되지 않습니다.");
        }
    }
}
