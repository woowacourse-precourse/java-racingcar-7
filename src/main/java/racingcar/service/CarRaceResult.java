package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Race;

import java.util.List;
import java.util.stream.Collectors;

public class CarRaceResult {

    private int MaxPosition;
    private Race race = new Race();

    public void carRaceResult(List<Car> carList){
        carPositionMax(carList);
        for(Car car : carList){
            if(car.getPosition() == MaxPosition){
                race.getWinner().add(car);
            }
        }
        carRaceResultPrint(race.getWinner());
    }

    private void carRaceResultPrint(List<Car> winner) {
        String result = winner.stream().map(Car::getCarName).collect(Collectors.joining(","));
        System.out.print("최종 우승자 : "+result);
    }

    private void carPositionMax(List<Car> carList) {
        race.getMaxheap().addAll(carList); // nlogn
        MaxPosition = race.getMaxheap().poll().getPosition(); // Car의 position
    }
}
