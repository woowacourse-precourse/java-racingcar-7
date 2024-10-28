package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.simulator.Simulator;
import racingcar.user.UserInput;

public class Application {
    public static void main(String[] args) {

        UserInput userInput = new UserInput();
        Simulator simulator;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String namesOfCarsInput = Console.readLine();
        String[] namesOfCars = userInput.readNamesOfCars(namesOfCarsInput);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberOfAttemptsInput = Console.readLine();
        int numberOfAttempts = userInput.readNumberOfAttempts(numberOfAttemptsInput);

        simulator = new Simulator(numberOfAttempts, namesOfCars);
        System.out.println();
        simulator.simulate();

    }
}
