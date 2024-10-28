package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;
    private final int attempts;

    public Race(List<Car> cars,int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = 0;

        // 자동차들의 최대 거리 구하기
        for(Car car : cars) {
            if(car.getPosition() > maxPosition){
                maxPosition = car.getPosition();
            }
        }

        // 최대거리에 위치한 자동차들 찾고 리스트에 추가
        for(Car car : cars) {
            if(car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

}
