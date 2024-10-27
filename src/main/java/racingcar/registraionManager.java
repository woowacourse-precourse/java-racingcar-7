package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class registraionManager {
    private static final int MAX_CAR_COUNT = 10;
    private static final int MIN_CAR_COUNT = 2;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    Car[] cars;

    public registraionManager(ArrayList<String> carNames){
        cars = new Car[carNames.size()];
        enroll(carNames);
    }

    public void enroll(ArrayList<String> name){
        for(int index=0; index < cars.length; index++){
            cars[index] = new Car(name.get(index));
        }
    }

    private String getLowerCaseName(String carName) {
        if (!Pattern.matches("[a-zA-Z]+", carName)) {
            throw new IllegalArgumentException("자동차 이름은 알파벳으로만 구성되어야 합니다.");
        }
        return carName.toLowerCase();
    }

    private static void isValidlengthName(String carName){
        if (carName.length() > MAX_CAR_NAME_LENGTH){
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void checkValidCarNames(){
        for(int i=0; i<cars.length; i++){
            String curCarName = cars[i].name();
            cars[i].rename(getLowerCaseName(curCarName));
            isValidlengthName(curCarName);
        }
    }

    public void checkDuplicatePlayer(){
        ArrayList<String> nameList= new ArrayList<>();
        for (int i=0; i<cars.length; i++){
            nameList.add(cars[i].name());
        }
        Set<String> nameSet = new HashSet<>(nameList);
        if(nameList.size() != nameSet.size()){
            throw new IllegalArgumentException("중복된 자동차 이름은 사용할 수 없습니다.(대문자와 소문자는 동일하게 인식됩니다.)");

        }
    }

    public void checkValidCarCount(){
        if ((cars.length > MAX_CAR_COUNT) || (cars.length < MIN_CAR_COUNT)){
            throw new IllegalArgumentException("자동차 대수는 2대 이상 10대 이하여야 합니다.");
        }
    }

    public Car[] getRegisteredPlayers(){
        return cars;
    }

    public int getRegisteredPlayersCount(){
        return cars.length;
    }

}
