package racingcar.model;

import java.util.List;

import racingcar.model.generator.NumberGenerator;

public class CarFactory {

    private final NumberGenerator numberGenerator;
    private final List<String> names;
    private List<Car> cars;

    public CarFactory(List<String> names, NumberGenerator numberGenerator){
        this.names = names;
        this.numberGenerator = numberGenerator;
        makeCars();
    }

    private void makeCars(){
        for(String name : names){
            cars.add(new Car(name, numberGenerator));
        }
    }

    public List<Car> getCars(){
        return cars;
    }
}
