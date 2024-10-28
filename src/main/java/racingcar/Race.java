package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;
import racingcar.car.RacingCar;

/**
 * 자동차 경주 게임을 관리하는 클래스. 여러 자동차의 경주를 진행하고 결과를 관리한다.
 *
 * @author JBumLee
 * @version 2024/10/26
 */
public class Race {
    private final List<Car> cars;
    private final int tryCount;

    /**
     * 레이스 객체를 생성한다. 자동차 이름 목록과 시도 횟수를 받아 레이스를 초기화한다.
     *
     * @param carNames 경주할 자동차 이름 목록
     * @param tryCount 시도할 횟수
     */
    private Race(List<String> carNames, int tryCount) {
        validateTryCount(tryCount);
        this.tryCount = tryCount;
        this.cars = carNames.stream()
                .map(RacingCar::create)
                .collect(Collectors.toList());
    }

    /**
     * 시도 횟수가 1 이상인지 검증한다.
     *
     * @param tryCount 검증할 시도 횟수
     * @throws IllegalArgumentException 시도 횟수가 1 미만인 경우
     */
    private void validateTryCount(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    /**
     * 한 라운드를 진행한다. 각 자동차의 이동 여부를 결정하고 이동시킨다.
     */
    private void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    /**
     * 전체 레이스를 시작한다. 지정된 횟수만큼 라운드를 진행하고 결과를 출력한다.
     */
    public void start() {
        for (int i = 0; i < tryCount; i++) {
            playRound();
            printRoundResult();
            System.out.println();
        }
        printWinners();
    }

    /**
     * 현재 라운드의 결과를 출력한다. 각 자동차의 이름과 이동 거리를 표시한다.
     */
    private void printRoundResult() {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
    }

    /**
     * 우승자 목록을 찾는다. 가장 멀리 이동한 자동차들의 이름을 반환한다.
     *
     * @return 우승자 이름 목록
     */
    private List<String> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    /**
     * 최종 우승자를 출력한다. 우승자가 여러 명일 경우 쉼표로 구분하여 출력한다.
     */
    private void printWinners() {
        List<String> winners = findWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    /**
     * 레이스 객체를 생성하는 정적 팩토리 메소드.
     *
     * @param carNames 경주할 자동차 이름 목록
     * @param tryCount 시도할 횟수
     * @return 생성된 레이스 객체
     */
    public static Race create(List<String> carNames, int tryCount) {
        return new Race(carNames, tryCount);
    }
}