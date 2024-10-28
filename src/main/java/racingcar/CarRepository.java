package racingcar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CarRepository {
    private  Map<String, ArrayList<Integer>> carMap = new HashMap();

    public Map<String, ArrayList<Integer>> getMap(){
        return carMap;
    }

    public void addCar(String carName){
        carMap.put(carName, new ArrayList<>());
    }

    public ArrayList<Integer> getCarPosition(String carName){
        return carMap.get(carName);
    }

    public CarRepository(){}
}
