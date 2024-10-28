package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.Message;

import java.util.ArrayList;
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

    public static void printWinners(Map<String, Integer> carForwardCount){

        StringBuilder result = new StringBuilder("최종 우승자 : ");
        List<String> maxKeys = new ArrayList<>();
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : carForwardCount.entrySet()) {

            int value = entry.getValue();

            if (value > maxValue) {
                maxValue = value;
                maxKeys.clear();
                maxKeys.add(entry.getKey());
            }
            else if (value == maxValue) {
                maxKeys.add(entry.getKey());
            }
        }

        for (int i = 0; i < maxKeys.size(); i++) {
            result.append(maxKeys.get(i));
            if (i < maxKeys.size() - 1) {
                result.append(", ");
            }
        }

        System.out.println(result.toString());
    }

}
