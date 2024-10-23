package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String input = Console.readLine();
        final List<String> carNames = Arrays.asList(input.split(","));

        validateCarNames(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        final String attemptInput = Console.readLine();
        final int attemptCount = validateAndParseAttemptCount(attemptInput);
    }

    private static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다: " + name);
            }
        }
    }

    private static int validateAndParseAttemptCount(String input){
        try{
            int attemptCount = Integer.parseInt(input);
            if(attemptCount <= 0){
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return attemptCount;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
