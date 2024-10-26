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

    public void userInputData(String carNames, String repeatNum){
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

    protected void saveCar(String carNames){
        List<String> carList = List.of(carNames.split(","));
        carList = carList.stream().map(String::trim).toList();
        cars = new Cars(carList);
    }

    protected List<String> getCarList(){
        return cars.getCarNames();
    }

    protected List<Integer> getDistanceList(){
        return cars.getDistance();
    }

    protected void racingRepeat(List<String> carList, String repeatNum){
        int repeat = Integer.parseInt(repeatNum);
        for(int i=0; i<repeat; i++){
            List<Boolean> carGoList = racingService.carGoList(carList);
            cars.setDistance(carGoList);
            userViewController.callRacingOutputView(carList, cars.getDistance());
        }
    }

}
