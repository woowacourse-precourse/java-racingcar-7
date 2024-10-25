package racingcar;


public class RacingCar{
    private String carNames;
    private int numOfTrial;

    public void readUserInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String stringUserInput = camp.nextstep.edu.missionutils.Console.readLine();
        numOfTrial = Integer.parseInt(stringUserInput);
    }
}
