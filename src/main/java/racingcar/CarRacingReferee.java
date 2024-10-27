package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRacingReferee implements Referee {
    @Override
    public List<Car> checkDrivingDistance(List<Car> carList) {
        List<Car> confirmedCar = new ArrayList<>();

        for(Car car : carList){
            Car judged = judgeMovement(car);
            confirmedCar.add(judged);
        }

        return confirmedCar;
    }

    @Override
    public Car judgeMovement(Car car) {
        if(car.judge(car.random())){
            car.addDistance();
        }
        return car;
    }

    @Override
    public List<Car> judgeWinner(List<Car> carList) {
        List<Car> winners = new ArrayList<>();
        int max = 0;

        for(Car car : carList){
            int distance = car.getDistance();
            if(distance > max) {
                max = distance;
                winners = new ArrayList<>();
                winners.add(car);
            } else if(distance == max) {
                winners.add(car);
            }
        }

        return winners;
    }
}
