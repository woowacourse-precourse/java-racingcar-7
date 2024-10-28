package manager;

import car.Car;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultManager {
    private final List<Car> carList;

    public ResultManager(List<Car> carList){
        this.carList = carList;
    }

    public String getWinners(){
        return "최종 우승자 : " + carList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}
