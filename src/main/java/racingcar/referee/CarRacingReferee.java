package racingcar.referee;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.Car;

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

        for (Car car : carList) {
            int distance = car.getDistance();
            updateWinners(winners, car, distance, max);
            max = Math.max(max, distance);
        }

        return winners;
    }

    private void updateWinners(List<Car> winners, Car car, int distance, int max) {
        if (distance > max) {
            winners.clear();
            winners.add(car);
        } else if (distance == max) {
            winners.add(car);
        }
    }
}
