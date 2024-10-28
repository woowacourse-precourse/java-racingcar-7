package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<String> names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars(){
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public void printCurrentPositions(){
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getMoveDisctance()));
        }
        System.out.println();
    }

    public void printWinners(){
        int maxMoveDistance = maxMoveDistance();
        List<String> winners = findWinners(maxMoveDistance);

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public int maxMoveDistance(){
        int maxMoveDistance = 0;

        for (Car car : cars) {
            if(car.getMoveDisctance() > maxMoveDistance){
                maxMoveDistance = car.getMoveDisctance();
            }
        }
        return maxMoveDistance;
    }

    public List<String> findWinners(int maxMoveDistance){
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if(car.getMoveDisctance() == maxMoveDistance){
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
