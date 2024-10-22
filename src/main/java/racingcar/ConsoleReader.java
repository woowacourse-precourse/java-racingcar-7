package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader {
    public static String readInput() {
        return Console.readLine();
    }

    public static void close(){
        Console.close();
    }
}
