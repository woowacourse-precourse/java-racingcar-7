package racingcar;

import racingcar.randomgenerator.RandomGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> names, RandomGenerator generator){
        for(String name : names){
            cars.add(new Car(name, generator));
        }
    }

    public void race(){
        for(Car car : cars){
            car.move();
            System.out.println(car.getMoveResult());
        }
    }

    public String getWinners(){
        int winnerMoveSize = cars.stream()
                .mapToInt(Car :: getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.isWinner(winnerMoveSize))
                .map(Car :: getName)
                .collect(Collectors.joining(", "));
    }
}
