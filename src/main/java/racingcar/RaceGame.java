package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceGame {
    private List<Car> cars;
    private int totalRounds;
    private RaceView view;

    public RaceGame(List<String> carNames, int totalRounds, RaceView view){
        validateRounds(totalRounds);
        this.totalRounds = totalRounds;
        this.cars = createCars(carNames);
        this.view = view;
    }
    private void validateRounds(int totalRounds){
        if (totalRounds <=0 ){
            throw new
                    IllegalArgumentException("총 시도 횟수는 1 이상이어야 합니다");
        }
    }
    private List<Car> createCars(List<String> carNames){
        List<Car> cars = new ArrayList<>();
        for(String name : carNames){
            cars.add(new Car(name));
        }
        return cars;
    }
    public void playRounds(){
        for(int i =0; i < totalRounds; i++){
            playSingleRound();
            view.displayRoundResults(cars);
        }
    }

    private void playSingleRound(){
        for (Car car:cars){
            if (shouldMove()){
                car.moveForward();
            }
        }
    }
    private boolean shouldMove(){
        return Randoms.pickNumberInRange(0,9) >= 4;
    }
    public List<Car> getWinners(){
        int maxPosition = findMaxPositiion();
        return cars.stream().filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
    }

    private int getMaxPosition(){
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }
    private int findMaxPositiion(){
        int maxPosition = 0;
        for (Car car : cars){
            if (car.getPosition() > maxPosition){
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
    private List<Car> findWinners(int maxPosition){
        List<Car> winners = new ArrayList<>();
        for (Car car : cars){
            if (car.isAtPosition(maxPosition)){
                winners.add(car);
            }
        }
        return winners;
    }
    public List<Car> getCars(){
        return cars;
    }
}
