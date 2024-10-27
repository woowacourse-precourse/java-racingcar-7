package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println();
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

    public void displayWinner(List<Car> cars) {
        List<Car> winners = findWinners(cars);

        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        // 결과 출력
        System.out.println("최종 우승자 : " + winnerNames);

    }

    private List<Car> findWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int maxScore = Integer.MIN_VALUE; // 최소 점수로 초기화

        for (Car car : cars) {
            int score = car.getScore();
            if (score > maxScore) {
                maxScore = score;
                winners.clear(); // 새로운 최고 점수 발견 시 이전 우승자 목록 초기화
                winners.add(car);
            } else if (score == maxScore) {
                winners.add(car); // 동일 점수일 경우 우승자 목록에 추가
            }
        }

        return winners; // 우승자 목록 반환
    }





}
