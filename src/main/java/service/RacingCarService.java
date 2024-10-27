package service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import model.Car;

public class RacingCarService {

    // 한 라운드를 실행
    public void playSingleRound(List<Car> cars) {
        processCarMovements(cars);
    }

    public void processCarMovements(List<Car> cars) {
        for (Car car : cars) {
            int randomValue = generateRandomValue();
            applyMovement(car, randomValue);
        }
    }

    // 랜덤 값 생성 함수
    private int generateRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    // 조건에 따라 자동차의 동작을 결정하는 함수
    private void applyMovement(Car car, int randomValue) {
        if (randomValue >= 4) {
            car.move();  // 전진
        }
        if (randomValue < 4) {
            car.stop();  // 멈춤
        }
    }

    // 우승자 찾기
    public List<String> findFinalWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return extractWinners(cars, maxPosition);
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private List<String> extractWinners(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (isWinner(car, maxPosition)) {
                addWinner(winners, car);
            }
        }
        return winners;
    }

    // 자동차가 우승자인지 확인하는 함수
    private boolean isWinner(Car car, int maxPosition) {
        return car.getPosition() == maxPosition;
    }

    // 우승자의 이름을 리스트에 추가하는 함수
    private void addWinner(List<String> winners, Car car) {
        winners.add(car.getName());
    }

    public boolean isPrintAllowed(int attempts) {
        return attempts <= 1000;
    }


}
