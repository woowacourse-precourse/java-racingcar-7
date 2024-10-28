package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceService {
    private final Cars cars;

    public RaceService() {
        this.cars = new Cars();
    }

    public void init(String input) {
        List<String> nameList = getNameList(input);
        List<Car> inputCars = nameToCars(nameList);
        setCars(inputCars);
    }

    private static List<String> getNameList(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    private static List<Car> nameToCars(List<String> nameList) {
        List<Car> inputCars = new ArrayList<>();
        for (String name : nameList) {
            inputCars.add(new Car(name));
        }
        return inputCars;
    }

    public void race() {
        for (Car car : cars.get()) {
            car.run(Randoms.pickNumberInRange(0, 9));
        }
    }

    public String getWinners(){
        String winners = "";
        int maxScore = getMaxScore();
        for (Car car : cars.get()) {
            if (car.getScore().equals(maxScore)){
                winners += ", "+car.getName();
            }
        }
        return winners.substring(2);
    }

    private int getMaxScore() {
        int maxScore = 0;
        for (Car car : cars.get()) {
            int score = car.getScore();
            if(maxScore < score){
                maxScore = score;
            }
        }
        return maxScore;
    }
    private void setCars(List<Car> inputCars) {
        cars.set(inputCars);
    }
    public Cars getCars(){
        return cars;
    }
}
