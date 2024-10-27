package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    static List<Car> winners = new ArrayList<>();

    int topForwardCount = 0;

    public List<Car> getWinners(){
        return winners;
    }

    public List<Car> determineWinners(List<Car> cars){
        cars.forEach(car -> {
            if(car.forwardCount > topForwardCount){
                winners.clear();
                topForwardCount = car.forwardCount;
            }
            if(car.forwardCount == topForwardCount){
                winners.add(car);
            }
        });
        return winners;
    }

}
