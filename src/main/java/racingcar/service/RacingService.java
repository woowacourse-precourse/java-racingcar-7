package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class RacingService {
    private Separator separator;
    private Validation validation;
    private List<Car> participantCars;
    private final int FORWARD_STANDARD = 4;

    public RacingService() {
        this.separator = new Separator();
        this.validation = new Validation();
        this.participantCars = new ArrayList<>();
    }
    public List<String> separateInputString(String inputString){
        try{
            return separator.separateString(inputString);
        }catch(IllegalArgumentException err){
            throw err;
        }
    }
    public void checkValidCarName(List<String> inputString){
        try{
            validation.validateString(inputString);
        }catch(IllegalArgumentException err){
            throw err;
        }
    }
    public void registrationCar(List<String> carNames){

        for (String carName : carNames) {
            Car car = new Car(carName, "");
            participantCars.add(car);
        }
    }
    public List<String> racing() {

        for (Car car : participantCars) {
            boolean forwardAvailable = checkForwardAvailable();

            if(forwardAvailable){
                car.moveFoward();
            }
        }

        List<String> roundResult = new ArrayList<>();
        for (Car car : participantCars) {
            roundResult.add(car.getDistance());
        }

        return roundResult;
    }
    public String getWinner() {
        StringJoiner sj = new StringJoiner(", ");

        int maxDistance = -1;

        for (Car car : participantCars) {
            if(car.getDistance().length() > maxDistance){
                maxDistance=car.getDistance().length();
            }
        }

        for (Car car : participantCars) {
            if(car.getDistance().length()==maxDistance){
                sj.add(car.getName());
            }
        }

        return sj.toString();
    }
    private boolean checkForwardAvailable() {
        final int randomInt = Randoms.pickNumberInRange(0,9);
        if (randomInt >= FORWARD_STANDARD) {
            return true;
        }else{
            return false;
        }
    }
}
