package racingcar.domain;

import java.util.List;
import racingcar.utility.StringUtility;

public class Cars {
    public List<Car> cars;

    public Cars(String raceCarNames){
        List<String> carNameList = StringUtility.splitStringToList(raceCarNames);
        for(String carName : carNameList){
            cars.add(new Car(carName));
        }
    }

    public int getCarSize(){
        return cars.size();
    }

}
