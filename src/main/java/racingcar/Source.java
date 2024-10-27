package racingcar;

public class Source {

    public static String[] inputCarNames(String input){
        return input.split(",");
    }

    public static int inputAttempts(String input){
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }
    }
}
