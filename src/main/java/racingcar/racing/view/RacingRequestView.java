package racingcar.racing.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.racing.dto.request.RacingRequestDTO;
import racingcar.racing.util.RacingRequestParser;

public class RacingRequestView {

    private static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_TIME_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static RacingRequestDTO request() {
        System.out.println(CAR_NAME_REQUEST_MESSAGE);
        String carNames = Console.readLine();
        List<String> parsedCarNames = RacingRequestParser.parseCarNames(carNames);

        System.out.println(RACING_TIME_REQUEST_MESSAGE);
        String round = Console.readLine();
        Integer parsedRound = RacingRequestParser.parseRound(round);

        Console.close(); // 이곳에서만 사용하고 재사용하지 않는다고 가정하여 사용 후 바로 종료

        return new RacingRequestDTO(parsedCarNames, parsedRound);
    }
}
