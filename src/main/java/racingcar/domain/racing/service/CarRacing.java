package racingcar.domain.racing.service;

import racingcar.domain.car.entity.Car;
import racingcar.domain.car.service.CarNameValidator;
import racingcar.domain.road.service.RandomRoadCreator;
import racingcar.domain.winner.service.WinnerPrinter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.domain.road.service.RoadPrinter.printRoad;

public class CarRacing {

    private final int step;
    private final List<Car> carList;
    RandomRoadCreator roadCreator = new RandomRoadCreator();
    WinnerPrinter winnerPrinter = new WinnerPrinter();

    public CarRacing(String cars, String step) {
        this.step = parseStep(step);
        this.carList = createCar(cars);
    }

    public void racing(){

        System.out.println("실행결과");
        for(int i = 0; i < step; i++){
            for(Car car : carList){
                roadCreator.addRandomRoad(car.getRoad());
                printRoad(car);
            }
            System.out.println();
        }
        winnerPrinter.printWinner(carList);
    }

    private List<Car> createCar(String cars){
        return Arrays.stream(cars.split(",")) // 문자열을 쉼표로 나누어 Stream 생성
                .filter(name -> !name.trim().isEmpty()) // 빈 문자열 필터링
                .peek(CarNameValidator::validate)
                .map(name -> new Car(name.trim())) // Car 객체 생성
                .collect(Collectors.toList()); // List<Car>로 수집
    }

    private int parseStep(String step){
        return Integer.parseInt(step);
    }
}
