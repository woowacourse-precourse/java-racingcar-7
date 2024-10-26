package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars=new ArrayList<>();

    public void initializeCars(List<String>carNames){
        for(String name:carNames){
            cars.add(new Car(name));
        }
    }
    public void race(int count){
        for(int i=0;i<count;i++){
            moveCars();
        }
    }
    public void moveCars(){
        for(Car car: cars){
            if(moveControl()){
                car.addDash();
            }
        }
    }
    public boolean moveControl(){
        int randomValue= Randoms.pickNumberInRange(0,9);
        return randomValue>=4;
    }
    public int getMaxDashCount(){
        return cars.stream()
                .mapToInt(Car::getDashCount)
                .max()
                .orElse(0);
    }
    public boolean isWinner(Car car, int maxDashes){
        return car.getDashCount()==maxDashes;
    }
}
