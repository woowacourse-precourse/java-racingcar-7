package racingcar.service;

import racingcar.config.Config;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class WinnerService {
    private int maxScore = -1;
    private List<String> winners = new ArrayList<>();

    //최대 Score 찾기
    private void searchMaxScore(List<Car> cars) {
        for (Car car : cars) {
            if (maxScore < car.getScore()) {
                maxScore = car.getScore();
            }
        }
    }

    //최대 Score을 갖는 car들 찾기
    public void SearchWinners(List<Car> cars, Config config) {
        searchMaxScore(cars);
        for (Car car : cars) {
            if (car.getScore()==maxScore){
                winners.add(car.getName());
            }
        }
    }


    //승리자들 반환하는 게터
    public List<String> getWinners() {
        return winners;
    }
}