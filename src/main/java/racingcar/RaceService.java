package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceService {

    private List<CarVO> cars;
    private int round;

    public RaceService(List<CarVO> userInputCars, int userInputRound){
        cars=userInputCars;
        round=userInputRound;
    }

    public void raceing(){
        for (CarVO car : cars) {
            car.runing();
        }
    }

    public void roundStart(){
        for (int i=0;i<round;i++){
            raceing();
        }
    }

    public List<CarVO> carsState() {
        return cars;
    }

    public int getMaxPosition(){
        int position=0;
        for (CarVO car : cars) {
            if(car.getPosition()>position){
                position=car.getPosition();
            }
        }
        return position;
    }


    public List<String> winnerCars() {
        List<String> winners = new ArrayList<>();
        for (CarVO car : cars) {
            if (car.getPosition() == getMaxPosition()) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }


}
