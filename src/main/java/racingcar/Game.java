package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<String> winners(List<Car> cars){
        int max=0;
        List<String> winners= new ArrayList<>();

        for(Car car : cars){
            if(car.getPosition()>max)
                max = car.getPosition();
        }
        for(Car car : cars){
            if(car.getPosition() == max){
                winners.add(car.name);
            }
        }
        return winners;
    }

    public void printWinners(List<String> winners){
        System.out.println("최종 우승자 : "+String.join(", ",winners));
    }
}
