package racingcar;

public class GameEngine {
    private RacingCar racingCar;
    private InputReader inputReader;

    private String carNames;
    private int numberOfTrial;

    public GameEngine(InputReader inputReader, RacingCar racingCar){
        this.inputReader = inputReader;
        this.racingCar = racingCar;
    }

    public void readUserInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = inputReader.readCarNames();
        System.out.println("시도할 횟수는 몇 회인가요?");
        numberOfTrial = inputReader.readNumberOfTrial();
    }
}
