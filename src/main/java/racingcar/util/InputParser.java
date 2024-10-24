package racingcar.util;

import racingcar.domain.RacingCar;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputParser {

    public static int takeGameLapsFromUser() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        final String userInput = readLine();
        final String GAME_NUMBER_REGEX = "^[1-9]\\d*$";
        validateUserInput(userInput, GAME_NUMBER_REGEX, "게임 횟수는 오직 양수만 가능합니다.");

        return Integer.parseInt(userInput);
    }
    public static List<RacingCar> collectRacingCarAsList() {
        final String[] racers = getRacersAsArrayFromUserInput();
        validateRacers(racers);

        return Arrays.stream(racers).map(RacingCar::new)
                .collect(Collectors.toList());
    }

    private static String[] getRacersAsArrayFromUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String userInput = readLine();
        final String RACERS_REGEX = "^([^,]{1,5})(,[^,]{1,5})*$";
        validateUserInput(userInput,RACERS_REGEX,"유효하지 않은 입력입니다.");

        final String DELIMITER = ",";
        return userInput.split(DELIMITER);
    }
    private static void validateRacers(String[] racers) {
        for (String racer : racers) {
            if (racer.length() > 5) {
                throw new IllegalArgumentException("드라이버의 이름은 5글자 이하로 해주십시오.");
            }
        }
    }
    private static void validateUserInput(
            final String userInput,
            final String regex,
            final String errorMessage) {
        final Matcher matcher = Pattern.compile(regex)
                .matcher(userInput);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
