package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final Validator validator;
    private final Judge judge;
    private List<Car> carList = new ArrayList<>();

    public Race() {
        this.validator = new Validator();
        this.judge = new Judge();
    }

    public void setup(String inputCars) {
        String[] strCars = separateInputCars(inputCars);

        for (String str : strCars) {
            carList.add(new Car(str));
        }
    }

    public String[] separateInputCars(String input) {
        return input.split(",");
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public void show(String name, String distance) {
        System.out.println(name + " : " + distance);
    }
}
