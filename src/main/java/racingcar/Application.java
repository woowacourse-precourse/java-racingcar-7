package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import racingcar.enums.PrintMessage;
import racingcar.utils.InputValidator;
import racingcar.utils.Parser;

public class Application {
    public static TreeMap<String, Integer> cars = new TreeMap<>();

    public static void main(String[] args) {
        System.out.println(PrintMessage.ENTER_CARS_PROMPT.getMessage());
        String inputCars = Console.readLine();

        System.out.println(PrintMessage.ENTER_TRIAL_COUNT_PROMPT.getMessage());
        String inputTrialCount = Console.readLine();

        InputValidator.validateCarNames(inputCars);
        InputValidator.validateTrialCount(inputTrialCount);

        initCars(inputCars);
        int trialCount = Integer.parseInt(inputTrialCount);

        System.out.println("\n"+PrintMessage.PRINT_RACE_RESULT.getMessage());
        while(trialCount-- > 0) {
            runRace();
        }

    }

    private static void runRace() {
        Set<String> carNames = cars.keySet();
        for(String carName : carNames){
            if(Randoms.pickNumberInRange(0, 9)>=4){
                cars.put(carName, cars.getOrDefault(carName, 0)+1);
            }
        }

        printRaceStatus();
    }

    private static void printRaceStatus() {
        Set<String> carNames = cars.keySet();
        for(String carName : carNames){
            System.out.println(carName + " : " + "-".repeat(cars.get(carName)));
        }

        System.out.println();
    }

    private static void initCars(String inputCars) {
        List<String> carNames = Parser.parseCarNames(inputCars);
        for(String carName : carNames) {
            cars.put(carName, 0);
        }
    }
}
