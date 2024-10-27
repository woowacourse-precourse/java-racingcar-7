package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarValueAssigner {

    int MIN = 1; // 최소값
    int MAX = 10; // 최대값

    public void assignRandomValue(List<Car> cars) {

        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(MIN, MAX); // 랜덤 값 생성

            car.setRandomValue(randomValue);// 자동차에 랜덤 값 할당

            updateScoreBasedOnComparison(car, randomValue);

            int score = car.getScore();
            String name = car.getName();

            System.out.println(name + " : " + generateScoreDisplay(score));
        }

    }

    public void updateScoreBasedOnComparison(Car car, int randomValue) {
        if (randomValue >= 4 && randomValue <= 10) {
            car.setScore(car.getScore() + 1); // 조건을 만족하면 점수 증가
        }
    }

    public String generateScoreDisplay(int score) {
        if (score <= 0) {
            return "";
        } else {
            return "-".repeat(score); // 점수만큼 "-" 반복
        }
    }



}
