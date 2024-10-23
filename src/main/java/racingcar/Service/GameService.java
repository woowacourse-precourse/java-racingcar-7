package racingcar.Service;

import racingcar.Model.Car;

import java.util.ArrayList;

public class GameService {
    public ArrayList<Car> Separate_Carnames(String Carnames) {
        String[] cars=Carnames.split(",");
        ArrayList<Car> carList=new ArrayList<>();
        for(int i=0;i<cars.length;i++){
            carList.add(new Car(cars[i]));
        }
        return carList;
    }
}
