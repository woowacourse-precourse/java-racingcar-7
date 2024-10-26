package racingcar.service;

import racingcar.entity.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.service.RoadPrinter.printRoad;

public class CarRacing {

    private final int step;
    private final List<Car> carList;
    RandomRoadCreator roadCreator = new RandomRoadCreator();
    WinnerPrinter winnerPrinter = new WinnerPrinter();

    public CarRacing(String cars, int step) {
        this.step = step;
        this.carList = addCar(cars);
    }

    private void racing(){

        for(int i = 0; i < step; i++){
            for(Car car : carList){
                roadCreator.addRandomRoad(car.getRoad());
                printRoad(car);
            }
        }

        winnerPrinter.printWinner(carList);

    }

    private List<Car> addCar(String cars){
        return Arrays.stream(cars.split(",")) // 문자열을 쉼표로 나누어 Stream 생성
                .filter(name -> !name.trim().isEmpty()) // 빈 문자열 필터링
                .map(name -> new Car(name.trim())) // Car 객체 생성
                .collect(Collectors.toList()); // List<Car>로 수집
    }




}
