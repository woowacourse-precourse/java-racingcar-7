package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.Entity.Car;
import racingcar.service.RandomNumberGenerator;

/**
 * 자동차 경주 게임의 핵심 로직을 관리하는 클래스입니다. 주어진 횟수만큼 경주를 진행하고, 각 자동차의 이동 기록을 저장합니다.
 */
public class RacingGame {
    // 경주에 참가하는 자동차들의 리스트
    private final List<Car> cars;

    // 무작위 수를 생성하는 객체 (자동차의 전진 여부를 결정)
    private final RandomNumberGenerator generator;

    // 경주 진행 중 각 라운드별 자동차들의 상태를 저장하는 리스트
    private final List<List<Car>> history = new ArrayList<>();

    /**
     * RacingGame 클래스의 생성자입니다.
     *
     * @param cars      경주에 참가할 자동차들의 리스트
     * @param generator 무작위 수 생성기 객체
     */
    public RacingGame(List<Car> cars, RandomNumberGenerator generator) {
        this.cars = cars;
        this.generator = generator;
    }

    /**
     * 주어진 이동 횟수만큼 경주를 실행합니다. 각 라운드마다 모든 자동차의 이동 여부를 결정하고, 그 결과를 기록합니다.
     *
     * @param moveCount 경주를 시도할 횟수
     */
    public void run(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            // 현재 라운드의 결과를 저장할 리스트 초기화
            List<Car> roundResult = new ArrayList<>();

            // 모든 자동차에 대해 이동 여부를 결정
            for (Car car : cars) {
                // 무작위 수가 4 이상이면 자동차를 전진
                if (generator.generate() >= 4) {
                    car.move();
                }
                // 현재 자동차의 상태를 깊은 복사하여 라운드 결과에 추가
                roundResult.add(new Car(car));
            }
            // 현재 라운드의 결과를 전체 히스토리에 추가
            history.add(roundResult);
        }
    }

    /**
     * 현재 경주에 참가하고 있는 모든 자동차들의 리스트를 반환합니다.
     *
     * @return 자동차들의 리스트
     */
    public List<Car> getCars() {
        return cars;
    }

    /**
     * 경주 진행 과정에서 각 라운드별 자동차들의 상태를 저장한 히스토리를 반환합니다.
     *
     * @return 라운드별 자동차 상태 히스토리
     */
    public List<List<Car>> getHistory() {
        return history;
    }
}
