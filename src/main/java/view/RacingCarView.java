package view;

import camp.nextstep.edu.missionutils.Console;
import message.Message;

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

}
