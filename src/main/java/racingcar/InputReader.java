package racingcar;

import java.util.HashMap;

public class InputReader {
    public String readCarNames(){
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        return userInput;
    }
    public int readNumberOfTrial(){
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        return Integer.parseInt(userInput);
    }
    public void showNumberOfMovement(String[] carNames, HashMap<String, Integer> movementRecord){
        for(String car : carNames){
            System.out.printf("%s : %s\n", car, "-".repeat(movementRecord.get(car)));
        }
        System.out.println();
    }
}
