package racingcar.model;

import racingcar.model.component.Car;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> cars;
    private final int tryTimes;
    private int maxPosition;

    public Game(int tryTimes) {
        this.cars = new ArrayList<>();
        this.tryTimes = tryTimes;  // 생성자에서 한 번만 초기화
    }

    public void addCar(String name) {
        cars.add(new Car(name));
    }

    public void moveCars(){
        for (Car car : cars) {
            car.move();
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryTimes() {
        return tryTimes;
    }

    public List<Car> getWinners(){
        List<Car> winners = new ArrayList<>();
        for(Car car : cars){
            if(car.getPosition() == maxPosition){
                winners.add(car);
            }
        }
        return winners;
    }



    //test only
    public void setMaxPosition(int maxPosition) {
        this.maxPosition = maxPosition;
    }
}
