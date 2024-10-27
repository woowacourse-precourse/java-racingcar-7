package racingcar;

import java.util.List;

public class Race {
    private List<Car> cars;
    private int raceCount;

    public Race(List<Car> cars, int raceCount){
        this.cars = cars;
        this.raceCount = raceCount;
    }

    public void start(){
        for (int i=0; i<raceCount; i++){
            for (Car car : cars){
                car.move();
                System.out.println(car.displayPosition());
            }
            System.out.println();
        }
    }
}
