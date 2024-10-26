package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarMoveHistoryDto;
import racingcar.utility.StringUtility;

public class RaceFormatter {

    private final static String RACE_DRAW_MESSAGE = "무승부";
    private final static String RESULT_RACE_PREFIX = "최종 우승자 : ";
    private final static String MOVE_HISTORY_FORMAT = "%s : %s";

    public static String formatCarMoveHistory(CarMoveHistoryDto carMoveHistoryDto){
        return String.format(MOVE_HISTORY_FORMAT,carMoveHistoryDto.carName(),carMoveHistoryDto.carMoveHistory());
    }

    public static String formatCarsMoveHistory(List<Car> cars){
        return cars
                .stream()
                .map(Car::toMoveHistoryDto)
                .map(RaceFormatter::formatCarMoveHistory)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public static String formatRaceResult(List<String> winners){
        String raceWinner = StringUtility.listToSplitStr(winners);
        if(raceWinner.isEmpty()){
            raceWinner = RACE_DRAW_MESSAGE;
        }
        return RESULT_RACE_PREFIX + raceWinner;
    }
}
