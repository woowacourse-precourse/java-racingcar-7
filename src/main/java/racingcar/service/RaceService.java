package racingcar.service;

import racingcar.domain.Car;
import racingcar.dto.UserInputDTO;

import java.util.List;

public class RaceService {

    private int numOfStages;
    private List<Car> carList;

    public void raceStart() {
        System.out.println(numOfStages);
        for (Car car : carList) {
            System.out.println(car.getName());
        }
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public void setNumOfStages(int numOfStages) {
        this.numOfStages = numOfStages;
    }

    public List<Car> getCarList(UserInputDTO userInputDTO) {
        return this.carList;
    }
}
