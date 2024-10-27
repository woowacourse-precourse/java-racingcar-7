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

}
