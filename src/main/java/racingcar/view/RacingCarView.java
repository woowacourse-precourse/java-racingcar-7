package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.Message;

import java.util.List;
import java.util.Map;

public class RacingCarView {

    public static String getCarsInput(){
        System.out.println(Message.INPUT_CARS_NAME);
        String input = Console.readLine();
        return input;
    }

    public static String getAttemptInput(){
        System.out.println(Message.INPUT_ATTEMPT);
        String input = Console.readLine();
        return input;
    }

    public static void printRacingResult(String carName, int forwardNumber){

        StringBuilder result = new StringBuilder(carName + " : ");
        result.append("-".repeat(Math.max(0, forwardNumber)));

        System.out.println(result.toString());
    }

    public static void printRacingResults(List<String> inputCarTokens, Map<String, Integer> carForwardCount){

        for(String name : inputCarTokens){
            printRacingResult(name, carForwardCount.get(name));
        }
        System.out.println();
    }


}
