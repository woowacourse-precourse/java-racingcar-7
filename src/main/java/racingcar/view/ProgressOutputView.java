package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ProgressOutputView implements OutputView{
    private final List<Car> carList;

    public ProgressOutputView(List<Car> carList){
        this.carList = carList;
    }

    public void print() {
        for(Car car: carList){
            System.out.println(makePrintFormat(car));
        }

        System.out.println();
    }

    private String makePrintFormat(Car car){
        String format = String.format("%s : %s", car.getName(), "-".repeat(car.getDistance()));

        return format;
    }
}
