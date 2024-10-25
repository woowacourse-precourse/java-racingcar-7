package racingcar.controller;

import racingcar.model.Cars;
import racingcar.service.RacingService;
import racingcar.service.ValidService;

import java.util.List;

public class UserRequestController {
    UserViewController userViewController = new UserViewController();
    ValidService validService = new ValidService();
    RacingService racingService = new RacingService();
    Cars cars;

    void userInputData(String carNames, String repeatNum){
        if(validService.isCarNames(carNames) && validService.isRepeat(repeatNum)){
            saveCar(carNames);
            List<String> carList = getCarList();
            racingRepeat(carList, repeatNum);
            List<Integer> distanceList = getDistanceList();
            List<String> winners = racingService.winnerCarList(carList, distanceList);
            userViewController.callWinnerOutput(winners);
        }else{
            userViewController.callErrorView();
        }
    }

    private void saveCar(String carNames){
        List<String> carList = List.of(carNames.split(","));
        cars = new Cars(carList);
    }

    private List<String> getCarList(){
        return cars.getCarNames();
    }

    private List<Integer> getDistanceList(){
        return cars.getDistance();
    }

    private void racingRepeat(List<String> carList, String repeatNum){
        int repeat = Integer.parseInt(repeatNum);
        for(int i=0; i<repeat; i++){
            List<Boolean> carGoList = racingService.carGoList(carList);
            cars.setDistance(carGoList);
            userViewController.callRacingOutputView(carList, cars.getDistance());
        }
    }

}
