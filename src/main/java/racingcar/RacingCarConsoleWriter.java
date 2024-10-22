package racingcar;

import java.util.List;

public class RacingCarConsoleWriter {

    public static void writeInputMessage(InputType inputType) {
        System.out.println(inputType.message);
    }

    public static void writeWinnerMessage(List<String> winners) {
        var winnerString = String.join(", ", winners);
        System.out.printf("최종 우승자 : %s\n", winnerString);
    }

    public static void writeCarState(String carName, int position) {
        if(position < 0) {
            throw new IllegalArgumentException("자동차의 위치는 음수가 될 수 없습니다.");
        }
        String carState = "-".repeat(position);
        System.out.printf("%s : %s%n", carName, carState);
    }


    public enum InputType {
        READ_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        READ_TRY_COUNT("시도할 횟수는 몇 회인가요?");

        public final String message;

        InputType(String message) {
            this.message = message;
        }

    }

}
