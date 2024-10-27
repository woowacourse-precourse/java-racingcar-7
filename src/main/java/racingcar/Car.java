package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Car {
    public String carName;
    public int carPosition;

    public Car(String carName){
        this.carName = carName;
        this.carPosition = 0;
    }
    public String getCarName(){
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }
    public void carMove(){
        int randomMovingNumber = Randoms.pickNumberInRange(0, 9);
        if(randomMovingNumber>= 4){
            carPosition++;
        } else if(randomMovingNumber < 4 && carPosition > 0){
            carPosition--;
        }
    }
}
