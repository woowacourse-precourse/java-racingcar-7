package service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import model.Car;

public class RacingCarService {

    // 한 라운드를 실행
    public void playRound(List<Car> cars) {
        moveOrStop(cars);
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
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public void moveOrStop(List<Car> cars) {
        int randomValue = Randoms.pickNumberInRange(0, 9);

        // 4 이상일 때 전진
        if (randomValue >= 4) {
            cars.forEach(Car::move);
        }

        // 4 미만일 때 멈춤
        if (randomValue < 4) {
            cars.forEach(Car::stop);
        }
    }

}