package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class GameEngine {
    private InputReader inputReader;

    private String carNames;
    private int numberOfTrial;
    private ArrayList<RacingCar>  racingCars;

    public GameEngine(InputReader inputReader){
        this.inputReader = inputReader;
    }

    public void readUserInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = inputReader.readCarNames();
        System.out.println("시도할 횟수는 몇 회인가요?");
        numberOfTrial = inputReader.readNumberOfTrial();
    }

    public void initializeGame() {
        for (String car : carNames.split(",")) {
            racingCars.add(new RacingCar(car));
        }
    }

    public void race(){
        for(RacingCar car : racingCars){
            car.race();
        }
    }

    public void showRaceRecord(){
        for(RacingCar car : racingCars){
            System.out.printf("%s : %s", car.getCarName(), "-".repeat(car.getRecord()));
            System.out.println();
        }
    }
    public void showRaceWinner(){
        int maxRecord = racingCars.stream()
                .mapToInt(RacingCar::getRecord)
                .max()
                .orElse(Integer.MIN_VALUE);
        String winners = racingCars.stream()
                .filter(car -> car.getRecord() == maxRecord)
                .map(RacingCar::getCarName)
                .collect(Collectors.joining(", "));
        System.out.printf("최종 우승자 : ");
        System.out.println(winners);
    }
    public void run(){
        while(numberOfTrial > 0){
            race();
            showRaceRecord();
            --numberOfTrial;
        }
        showRaceWinner();
    }
}
