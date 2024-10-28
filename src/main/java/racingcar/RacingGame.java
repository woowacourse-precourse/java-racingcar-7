package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    List<Car> cars;
    int tryNum;

    public RacingGame(String[] carNames,int tryNum){
        this.cars = createCars(carNames);
        this.tryNum = tryNum;
    }

    public List<Car> createCars(String[] carNames){
        List<Car> cars = new ArrayList<>();
        for (String name : carNames){
            cars.add(new Car(name));
        }
        return cars;
    }

    public void play(){
        for (int i = 0; i < tryNum; i++){
            race();
            printCurrentRaceStatus();
        }
    }

    public void race(){
        for (racingcar.Car car : cars){
            car.move(generateRandomNumber());
        }
    }

    public int generateRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public void printCurrentRaceStatus(){
        for (racingcar.Car car : cars){
            System.out.println(car.name + " : " + car.getDistanceString());
        }
        System.out.println();
    }

    public List<String> getWinners(){
        int maxDistance = getMaxDistance();
        return findWinners(maxDistance);
    }

    public int getMaxDistance(){
        int maxDistance = 0;
        for (racingcar.Car car : cars){
            int distance = car.distance;
            if(distance > maxDistance){
                maxDistance = distance;
            }
        }
        return maxDistance;
    }

    public List<String> findWinners(int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (racingcar.Car car : cars) {
            addWinnerIfMaxDistance(winners, car, maxDistance);
        }
        return winners;
    }

    public void addWinnerIfMaxDistance(List<String> winners, racingcar.Car car, int maxDistance) {
        if (car.distance == maxDistance) {
            winners.add(car.name);
        }
    }


}
