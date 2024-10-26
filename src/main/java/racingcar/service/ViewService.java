package racingcar.service;

import racingcar.controller.ViewController;

public class ViewService {
    private static ViewService viewService;
    public static ViewService getInstance() {
        if ( viewService== null){
            viewService = new ViewService();
        }
        return viewService;
    }
    public String[] inputValidation(String carName){
        String[] carNames = carName.split(",");
        return carNames;
    }

    public int countValidation(String count){
        int countNum = Integer.parseInt(count);
        return countNum;
    }
}
