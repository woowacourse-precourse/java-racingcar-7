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

    public static void writeRoundStartMessage(){
        System.out.println("\n실행 결과");
    }

    public static void writeCarState(List<RacingCarState> currentRacingCarStates) {
        for (RacingCarState racingCarState : currentRacingCarStates) {
            String carState = "-".repeat(racingCarState.getPosition());
            System.out.printf("%s : %s%n", racingCarState.getCarName(), carState);
        }
        System.out.println();
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
