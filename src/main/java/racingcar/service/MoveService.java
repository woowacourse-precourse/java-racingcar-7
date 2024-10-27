package racingcar.service;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.Car;

public class MoveService {

    public void possibleMoveCheck(Car car){
        if(Randoms.pickNumberInRange(0, 9)>=4){
            car.move();
        }
    }

    public int checkMaximumMove(List<Car> cars){
        int distanceMaximum=0;
        distanceMaximum = getMaximum(cars, distanceMaximum);

        return distanceMaximum;
    }

    public List<String> winnerSave(List<Car> cars, int maximum){
        List<String> winners = new ArrayList<>();

        checkWinner(cars, maximum, winners);

        return winners;
    }

    private static void checkWinner(List<Car> cars, int maximum, List<String> winners) {
        for (Car car : cars) {
            if(car.lengthSize()== maximum){
                winners.add(car.getName());
            }
        }
    }

    private static int getMaximum(List<Car> cars, int maximum) {

        for (Car car : cars) {
            if(car.lengthSize()> maximum) maximum =car.lengthSize();
        }

        return maximum;
    }

}
