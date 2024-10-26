package racingcar;

import java.util.Map;

public class RacingRace {
    DataManagement dataManagement = new DataManagement();
    Map<String, String> currentCarData = dataManagement.getCarData();
    String[] carNames = dataManagement.splitCarNames();

    InputMessage inputMessage = new InputMessage();
    String tryRacingRaces = inputMessage.inputNumberOfTries();

    OutputMessage outputMessage = new OutputMessage();

    Car car = new Car();

    public void racingRaceParticipation(String carName){
        currentCarData.put(carName, "");
    }

    public void readyStartingLine(){
        for (String carName : carNames) {
            racingRaceParticipation(carName);
        }
    }

    public void racingStart(){
        for (String carName : carNames) {
            car.Status(carName);
            outputMessage.printRaceResult(carName);
        }
        System.out.println();
    }

    public void raceCount(){
        for(int i=0; i<Integer.parseInt(tryRacingRaces); i++){
            racingStart();
        }
    }
}
