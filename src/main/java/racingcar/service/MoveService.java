package racingcar.service;
import camp.nextstep.edu.missionutils.Randoms;
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

    private static int getMaximum(List<Car> cars, int maximum) {

        for (Car car : cars) {
            if(car.lengthSize()> maximum) maximum =car.lengthSize();
        }

        return maximum;
    }

}
