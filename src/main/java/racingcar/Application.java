package racingcar;

import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.racing.Racing;
import racingcar.util.RacingUtils;

import java.util.List;

public class Application {

    private static final Input input = new Input();
    private static final Output output = new Output();

    public static void main(String[] args) {
        // 자동차들의 이름 입력받기
        output.printInputName();
        List<String> names = RacingUtils.divideComma(input.getUserAnswer());

        // 실행 횟수 입력받기
        output.printExecuteCount();
        int execute = RacingUtils.parseInt(input.getUserAnswer());

        // racing을 하기 위한 객체 생성
        Racing racing = new Racing(names);

        // racing 경과 출력
        output.printRacingResult();
        while (execute-- > 0) {
            List<String> race = racing.race(); // car들이 움직이도록 실행
            output.printRaceProcess(race); // 실행 경과 출력
        }

        // 우승자 출력
        List<String> winners = racing.getWinners(); // 우승자 이름 가져오기
        String result = RacingUtils.joinWithCommaAndWhiteSpace(winners); // 우승자 이름 리스트를 ", "로 join하여 하나의 문자열로 반환
        output.printWinner(result);// 출력
    }
}
