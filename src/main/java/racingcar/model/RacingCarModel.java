package racingcar.model;

import racingcar.validator.RacingCarValidator;

import java.util.*;

public class RacingCarModel {
    private final LinkedHashMap<String, Integer> carHashMap = new LinkedHashMap<>();
    private static final int INITIAL_FORWARD_COUNT = 0;
    public List<String> carNameList = new ArrayList<>();
    public List<String> winnerList = new ArrayList<>();


    public void setCarHashMap(){
        for (String carName : carNameList){
            addRacingCar(carName, INITIAL_FORWARD_COUNT);
        }
    }


    public void setCarNameList(String carNameString){
        Arrays.stream(carNameString.split(","))
                .map(String::trim)
                .peek(RacingCarValidator::isValidCarName)
                .forEach(carNameList::add);
    }


    public List<String> getCarNameList(){
        return carNameList;
    }


    public void addRacingCar(String carName, int forwardCount){
        carHashMap.put(carName, forwardCount);
    }


    public void updateCarMap(String carName){
        int carForwardCount = carHashMap.get(carName) + 1;
        carHashMap.put(carName, carForwardCount);
    }


    public int getForwardCount(String carName){
        return carHashMap.get(carName);
    }


    public void setWinnerList(){
        int maxValue = Collections.max(carHashMap.values());
        carNameList.stream()
                .filter(carName -> carHashMap.get(carName).equals(maxValue))
                .forEach(winnerList::add);
    }


    public List<String> getWinnerList(){
        setWinnerList();
        return winnerList;
    }

}
