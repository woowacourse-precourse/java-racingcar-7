package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarListParser {
    private final String input;

    public CarListParser(String input){
        this.input = input;
    }

    public List<Car> parsingData(){
        List<Car> carList = new ArrayList<>();

        for(String carName: input.split(",")){
            carList.add(new Car(carName.trim()));
        }

        return carList;
    }
}
