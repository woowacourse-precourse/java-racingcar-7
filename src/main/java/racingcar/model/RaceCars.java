package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import racingcar.exception.ExceptionCode;

import static racingcar.model.Number.LIMIT_NUMBER;
import static racingcar.controller.CarStatusController.printCarStatus;
import static racingcar.model.Random.createRandomNumber;


public class RaceCars {

    private static ArrayList<CarInfo> participantCars;

    public RaceCars() {
        participantCars = new ArrayList<>();
    }

    public static ArrayList<CarInfo> getParticipantCars() {
        return participantCars;
    }

    public void createRaceCar(String[] carNames) {
        for (String name : carNames) {
            CarInfo car = new CarInfo(name);
            participantCars.add(car);
        }
    }


    public void raceStart(String limitNumber) {
        validAllLimit(limitNumber);
        for (int i = 0; i < LIMIT_NUMBER; i++) {
            calculateRandomMovement();
            printCarStatus();
            System.out.println("\n");
        }
    }
    public ArrayList<CarInfo> findWinner() {
        ArrayList<CarInfo> winners = new ArrayList<>();
        long maxMovement = findMaxMovement();

        for (CarInfo car : participantCars) {
            if (car.moveCount == maxMovement) {
                winners.add(car);
            }
        }

        return winners;
    }

    public long findMaxMovement() {
        return participantCars.stream().max(Comparator.comparingLong(car -> car.moveCount))
                .orElseThrow(() -> new IllegalArgumentException(ExceptionCode.NO_RACE_CAR.getMessage())).moveCount;
    }

    public void calculateRandomMovement() {
        for (CarInfo car : participantCars) {
            int randNumber = 0;
            randNumber = createRandomNumber();
            Random.validRandomNumber(randNumber, car);
        }
    }

    public void validAllLimit(String limitNumber){
        validLimitNumber(limitNumber.trim());
        setLimitNumber(limitNumber.trim());
    }

    private void validLimitNumber(String limitNumber) {
        if (limitNumber.isEmpty()) {
            throw new IllegalArgumentException(ExceptionCode.EMPTY_LIMIT_NUMBER.getMessage());
        }
    }

    private void setLimitNumber(String limitNumber) {
        LIMIT_NUMBER = Integer.parseInt(limitNumber);
    }


}





