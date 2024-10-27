package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputMessage {
    private static final Pattern INVALID_PATTERN = Pattern.compile("[^a-zA-Z0-9]");
    public static final int CAR_NAME_LIMITS = 5;

    public String[] inputCarNameReturnSplit(String separator) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();

        String[] splitCarNames = inputCarName.split(separator);
        validateInput(splitCarNames);

        return splitCarNames;
    }

    public String inputNumberOfTries(){

        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public void validateInput(String[] carNames){

        for (String carName : carNames) {
            // 자동차 이름이 5자 초과 시 예외 발생
            if (carName.trim().length() > CAR_NAME_LIMITS) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다: " + carName);
            }

            // 자동차 이름이 문자, 숫자 이외의 것들이 들어갈 시 예외 발생
            if (INVALID_PATTERN.matcher(carName.trim()).find()) {
                throw new IllegalArgumentException("자동차 이름은 영대소문자와 숫자 밖에 안 됩니다.");
            }

            // null값 입력 금지
            if (carName.isEmpty()){
                throw new IllegalArgumentException("아무것도 입력하지 않으시면 게임이 시작되지 않습니다.");
            }
            // 빈 칸 입력 금지
            if (carName.contains(" ")){
                throw new IllegalArgumentException("빈 칸을 입력하지 마세요.");
            }
        }
        // 자동차를 2대 이상 입력했는 지 테스트
        if (carNames.length < 2){
            throw new IllegalArgumentException("자동차를 두 대 이상 입력하셔야 합니다.");
        }
    }
}
