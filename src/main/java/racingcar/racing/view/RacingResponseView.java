package racingcar.racing.view;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.racing.dto.response.CarResult;
import racingcar.racing.dto.response.RacingResponseDTO;

public class RacingResponseView {

    private static final String RESULT_TITLE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자";

    private static final String POSITION_STRING = "-";

    public static void response(RacingResponseDTO racingResponseDTO) {
        System.out.println(RESULT_TITLE);
        IntStream.range(0, racingResponseDTO.round()).forEach(round -> {
            racingResponseDTO.carResults().forEach(carResult -> {
                String name = carResult.name();
                Integer position = carResult.positionPerRound().get(round);
                System.out.println(name + " : " + POSITION_STRING.repeat(position));
            });
            System.out.println();
        });

        String winners = racingResponseDTO.carResults()
                .stream().filter(CarResult::isWinner)
                .map(CarResult::name)
                .collect(Collectors.joining(", "));
        System.out.println(WINNER_MESSAGE + " : " + winners);
    }
}
