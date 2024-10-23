package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.ClassOrderer;
import racingcar.Model.Car;

import java.util.ArrayList;
import java.util.Random;

public class GameService {
    public ArrayList<Car> Separate_Carnames(String Carnames) {
        String[] cars=Carnames.split(",");
        ArrayList<Car> carList=new ArrayList<>();
        for(int i=0;i<cars.length;i++){
            carList.add(new Car(cars[i]));
        }
        return carList;
    }
    public int Generate_RandomValue(){
        return Randoms.pickNumberInRange(0,9);
    }
}
