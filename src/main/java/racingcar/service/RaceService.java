package racingcar.service;

import racingcar.domain.Car;
import racingcar.dto.UserInputDTO;
import racingcar.util.InputParser;

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

    public void initialize(UserInputDTO userInputDTO) {
        this.numOfStages = userInputDTO.numOfStages();
        this.carList = InputParser.getCarList(userInputDTO);
    }

    public int getNumOfStages() {
        return this.numOfStages;
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public List<Car> getCarList(UserInputDTO userInputDTO) {
        return this.carList;
    }
}
