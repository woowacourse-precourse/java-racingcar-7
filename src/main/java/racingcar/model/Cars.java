package racingcar.model;

import java.util.ArrayList;
import racingcar.randomNumber.RandomNumber;

public class Cars {
    private final ArrayList<Car> cars;
    private int maxMove;
    private final ArrayList<String> winners;
    private final RandomNumber randomNumber = new RandomNumber();

    public Cars(){
        this.cars = new ArrayList<>();
        this.maxMove = 0;
        this.winners = new ArrayList<>();
    }

    public void addCarByName(String carName) {
        Car car = new Car(carName);
        cars.add(car);
    }
    public void play(){
        for (Car car : cars){
            car.updatePosition(randomNumber.randomNumberGenerator());
        }
    }

    public void calculateMaxMove(){
        for(Car car : cars){
            if (car.getPosition() > maxMove){
                maxMove = car.getPosition();
            }
        }
    }

    public void determineWinners(){
        for(Car car : cars){
            if(car.getPosition() == maxMove){
                winners.add(car.getName());
            }
        }
    }

    public ArrayList<Car> getCars(){
        return cars;
    }
    public ArrayList<String> getWinners(){return winners;}
}
