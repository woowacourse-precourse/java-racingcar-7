package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car;

import java.util.ArrayList;

public class CarService {
    private int Generate_RandomValue(){
        return Randoms.pickNumberInRange(0,9);
    }
    public boolean is_Move(int value){
        if(value>=4) return true;
        return false;
    }
    public void Move(ArrayList<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            int value = Generate_RandomValue();
            if (is_Move(value)) {
                cars.get(i).setPosition();
            }
        }
    }

}
