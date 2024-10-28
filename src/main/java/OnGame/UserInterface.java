package OnGame;
import camp.nextstep.edu.missionutils.Console;
import java.text.MessageFormat;
import java.util.List;

public class UserInterface{
    public enum ConsoleOutput{
        CAR_NAME_INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        RESULT_INFO("실행 결과"),
        WINNER_INFO("최종 우승자 : ");

        private final String message;

        ConsoleOutput(final String message){
            this.message = message;
        }

        public String getMessage(){
            return message;
        }
    }

    public String[] getCarName(){
        System.out.println(ConsoleOutput.CAR_NAME_INPUT.getMessage());

        final String input = Console.readLine();
        return input.split(",");
    }

    public String getCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return Console.readLine();
    }

    public void printRacingResult() {
        System.out.println(MessageFormat.format("\n{0}", ConsoleOutput.RESULT_INFO.getMessage()));
    }

    public void printScore(final String key, final int value) {
        String forwardDist = "-".repeat(value);
        System.out.println(MessageFormat.format("{0} : {1}", key, forwardDist));
    }

    public void printWinner(final List<String> names) {
        final String winners = String.join("-", names);
        System.out.println(ConsoleOutput.WINNER_INFO.getMessage() + winners);
    }
}
