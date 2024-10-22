package racingcar;

public abstract class Printer {

    public static void print(SystemMessage message) {
        System.out.println(message.getMessage());
    }
    
}
