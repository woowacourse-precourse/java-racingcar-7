package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> carList = new ArrayList<>();
    private Integer tryCount;

    public Race(List<String> carList, Integer tryCount) {
        for (String s : carList) {
            this.carList.add(new Car(s));
        }
        this.tryCount = tryCount;
    }

    public void raceStart(){
        for(int i=0; i<tryCount; i++){
            executeTurn();
        }
    }

    public void executeTurn(){
        for (Car car : carList) {
            if(isMovable()){
                car.move();
            }
        }
        IOController.printCurrentState(carList);
    }

    public boolean isMovable(){
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public List<String> getRaceWinners(){
        List<String> winnerList = new ArrayList<>();
        Integer longestDistance = getLongestDistance(carList);
        for (Car car : carList) {
            if(car.getMoveCount().length() == longestDistance){
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    public static Integer getLongestDistance(List<Car> carList){
        return carList.stream()
                .map(Car::getMoveCount)
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }
}
