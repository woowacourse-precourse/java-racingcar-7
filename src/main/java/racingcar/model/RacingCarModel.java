package racingcar.model;

import racingcar.validator.RacingCarValidator;

import java.util.*;

public class RacingCarModel {

    private LinkedHashMap<String, Integer> carHashMap = new LinkedHashMap<>();
    public List<String> carNameList = new ArrayList<>();
    public List<String> winnerList = new ArrayList<>();


    public void splitCarNameString(String carNameString){
        String[] carNamesArray = carNameString.split(",");
        for (String carName : carNamesArray) {
            carName = carName.trim();
            RacingCarValidator.isValidCarName(carName);
            addRacingCar(carName, 0);
        }
        createCarNameList(carNamesArray);
    }

    private void createCarNameList(String[] carNamesArray){
        carNameList = Arrays.asList(carNamesArray);
    }

    public void addRacingCar(String carName, Integer forwardCount){
        carHashMap.put(carName, forwardCount);
    }

    public List<String> getCarNameList(){
        return carNameList;
    }

    public void updateCarMap(String carName){
        Integer carForwardCount = carHashMap.get(carName);
        Integer updatedForwardCount = carForwardCount + 1;
        carHashMap.put(carName, updatedForwardCount);
    }


    public Integer getForwardCount(String carName){
        return carHashMap.get(carName);
    }


    private void findRacingWinner(){
        Integer maxValue = Collections.max(carHashMap.values());

        for (String car : carNameList) {
            if (carHashMap.get(car).equals(maxValue)){
                winnerList.add(car);
            }
        }
    }

    public List<String> getWinnerList(){
        findRacingWinner();
        return winnerList;
    }

}
