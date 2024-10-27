package racingcar;

import java.util.ArrayList;
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

    public int getMaxPosition(){
        int maxPosition = 0;
        for (Car car : cars){
            if (car.getPosition() >= maxPosition){
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars){
            if (car.getPosition() == maxPosition){
                winners.add(car);
            }
        }
        return winners;
    }
}
