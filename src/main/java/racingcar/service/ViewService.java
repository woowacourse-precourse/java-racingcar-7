package racingcar.service;

import racingcar.util.Utils;

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
        for (String name : carNames) {
            if(name.length() > Utils.MAX_NAME_SIZE){
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }

    public int countValidation(String count){
        int countNum = Integer.parseInt(count);
        if(countNum < 1){
            throw new IllegalArgumentException();
        }
        return countNum;
    }
}
