package racingcar;

import java.util.ArrayList;

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

    public void initializeGame(){
        for(String car : carNames.split(",")){
            racingCars.add(new RacingCar(car));
        }
    }
}
