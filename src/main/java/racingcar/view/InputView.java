package racingcar.view;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static List<String> inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
        String input=readLine();
        return Arrays.asList(input.split(","));
    }

    public static int inputAttemptCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        while (true){
            try {
                int count=Integer.parseInt(readLine());
                validateAttemptCount(count);
                return count;
            }catch(NumberFormatException e){
                System.out.println("유효한 숫자를 입력하세요.(ex 양수)");
            }
        }
    }

    private static void validateAttemptCount(int count) {
        if(count<=0){
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
