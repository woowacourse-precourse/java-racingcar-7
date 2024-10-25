package racingcar.controller;

import racingcar.model.Cars;
import racingcar.service.ValidService;

import java.util.List;

public class UserRequestController {
    UserViewController userViewController = new UserViewController();
    ValidService validService = new ValidService();
    Cars cars;

    void userInputData(String carNames, int repeatNum){
        if(validService.isInput(carNames) && validService.isInput(repeatNum)){
            saveCar(carNames);
        }else{
            userViewController.callErrorView();
        }
    }

    void saveCar(String carNames){
        List<String> carList = List.of(carNames.split(","));
        cars = new Cars(carList);
    }
    
}
