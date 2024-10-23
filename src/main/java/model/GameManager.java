package model;

import dto.CarDTO;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<Car> carList;
    private int runTimes;

    public GameManager(List<String> carNameList, int runTimes) {
        this.runTimes = runTimes;
        for (String carName : carNameList) {
            this.carList.add(new Car(carName));
        }
    }

    
    //한번의 레이싱
    private List<CarDTO> raceOnce() {
        List<CarDTO> carDTOList = new ArrayList<>();
        for (Car car : this.carList) {
            car.goOrNot();
            carDTOList.add(new CarDTO(car.getName(), car.getDistance()));
        }
        return carDTOList;
    }

    // 레이싱 진행
    public List<List<CarDTO>> raceGameManage() {
        List<List<CarDTO>> racingResult = new ArrayList<>();
        for (int i = 0; i < this.runTimes; i++) {
            racingResult.add(this.raceOnce());
        }
        return racingResult;
    }
}
