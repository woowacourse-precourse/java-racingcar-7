package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.List;

public class GameManager {

    private List<Car> cars;
    private int gameCount;
    private int currentCount;
    private CarManager carManager;

    public GameManager(String[] cars, int gameCount){
        this.carManager = new CarManager();
        this.gameCount = gameCount;
        carManager.createCars(cars);
        this.cars = carManager.getCars();
        clearCurrentCount();
    }

    public List<Car> getWinners(){
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public boolean isGameOver(){
        return currentCount >= gameCount;
    }

    public void playGame() {
        for (Car car : cars){
            if(Randoms.pickNumberInRange(0,9) >= 4){
                car.moveForward();
            }
        }
        currentCount++;
    }

    private void clearCurrentCount(){
        this.currentCount = 0;
    }

    public List<Car> getCars(){
        return cars;
    }
}
