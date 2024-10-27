package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.view.OutputView;

public class RacingGame {
    private final List<Car> cars=new ArrayList<>();
    private static final OutputView outputview=new OutputView();

    public void initializeCars(List<String>carNames){
        for(String name:carNames){
            cars.add(new Car(name));
        }
    }
    public void race(int count){
        for(int i=0;i<count;i++){
            moveCars();
            outputview.printCarList(cars);
        }
    }
    public void moveCars(){
        for(Car car: cars){
            if(moveControl()){
                car.addDash();
            }
        }
    }
    private boolean moveControl(){
        int randomValue= Randoms.pickNumberInRange(0,9);
        return randomValue>=4;
    }
    public List<String> findWinners() {
        int maxDashes = getMaxDashCount();
        return getWinnersByMaxDash(maxDashes);
    }
    private int getMaxDashCount(){
        return cars.stream()
                .mapToInt(Car::getDashCount)
                .max()
                .orElse(0);
    }
    private boolean isWinner(Car car, int maxDashes){
        return car.getDashCount()==maxDashes;
    }
    private List<String> getWinnersByMaxDash(int maxDashes) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (isWinner(car, maxDashes)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
