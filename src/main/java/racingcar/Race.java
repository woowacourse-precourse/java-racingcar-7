package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Race {

    private int totalRound;
    private ArrayList<Car> cars;

    public void init() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String carsRawInput = Console.readLine();
        cars = createCars(carsRawInput);
        System.out.println("시도할 횟수는 몇 회인가요?");
        String totalRoundRawInput = Console.readLine();
        totalRound = parseTotalRound(totalRoundRawInput);
    }

    private ArrayList<Car> createCars(String carsRawInput) {
        if (null == carsRawInput || carsRawInput.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        String[] carNames = carsRawInput.split(",");
        ArrayList<Car> cars = new ArrayList<Car>();
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능하다.");
            }
            cars.add(new Car(carName));
        }
        return cars;
    }

    private int parseTotalRound(String totalRoundRawInput) {
        try {
            int round = Integer.parseInt(totalRoundRawInput);
            if (round < 0) {
                throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
            }
            return round;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    public void start() {
        System.out.println("실행 결과");
        for (int currentRound = 0; currentRound < totalRound; ++currentRound) {
            round();
        }
        System.out.println("최종 우승자 : " + getWinner());
    }

    private void round() {
        for (Car car : cars) {
            car.moveIfPossible(Randoms.pickNumberInRange(0, 9));
            System.out.println(car.getStatus());
        }
        System.out.println();
    }

    private String getWinner() {
        int maxPosition = getMaxPosition();
        StringBuilder winner = new StringBuilder();
        cars.stream().filter(car -> car.getPosition() == maxPosition).forEach(car -> winner.append(car.getName()).append(","));
        return winner.substring(0, winner.length() - 1);
    }

    private int getMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElseThrow(IllegalStateException::new);
    }

}
