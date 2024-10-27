package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 경주 게임을 관리하는 클래스
 */
public class Game {
    private final List<Car> cars;
    private final int attempts;
    private int currentRound;


    /**
     * @param carNames 참가할 자동차들의 이름 목록
     * @param moveStrategy 자동차들의 이동 전략
     * @param attempts 총 시도 횟수
     */
    public Game(List<String> carNames, MoveStrategy moveStrategy, int attempts) {
        this.cars = carNames.stream()
                .map(name -> new Car(name, moveStrategy))
                .collect(Collectors.toList());
        this.attempts = attempts;
        this.currentRound = 0;
    }

    // 한 라운드를 진행
    public void playRound() {
        if (currentRound >= attempts) {
            return;
        }

        //모든 자동차가 한 번씩 이동을 시도
        cars.forEach(Car::move);
        currentRound++;
    }

    //게임이 종료되었는지 확인
    public boolean isFinished() {
        return currentRound >= attempts;
    }

    //가장 멀리 이동한 자동차들의 이름을 반환
    public List<String> getWinners() {
        // 최대 이동 거리를 계산
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
