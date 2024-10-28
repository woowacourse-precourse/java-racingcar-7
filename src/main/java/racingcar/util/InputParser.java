package racingcar.util;

import racingcar.domain.RacingCar;
import racingcar.exception.InvalidDriverNamesException;
import racingcar.exception.InvalidLapNumberException;
import racingcar.exception.NotUniqueDriverException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.util.InputRegexConst.*;

public class InputParser {
    //TODO: REGEX 상수 클래스로 따로 뺴기
    public static int takeGameLapsFromUser() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        final String userInput = readLine();
        if (!isMatchWithRegex(userInput, LAPS_NUMBER_REGEX.getRegex())) {
            throw new InvalidLapNumberException();
        }
        return Integer.parseInt(userInput);
    }
    public static List<RacingCar> collectRacingCarAsList() {
        final String[] racers = getRacersAsArrayFromUserInput();
        validateUniqueRacers(racers);

        return Arrays.stream(racers).map(RacingCar::new)
                .collect(Collectors.toList());
    }
    private static String[] getRacersAsArrayFromUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String userInput = readLine();
//        validateUserInput(userInput, RACERS_NAME_REGEX.getRegex(), "드라이버의 이름은 5글자 이하로 해주십시오.");
        if (!isMatchWithRegex(userInput, RACERS_NAME_REGEX.getRegex())) {
            throw new InvalidDriverNamesException();
        }
        final String DELIMITER = ",";
        return userInput.split(DELIMITER);
    }

    public static boolean isMatchWithRegex(final String userInput, final String regex) {
        final Matcher matcher = Pattern.compile(regex)
                .matcher(userInput);
        return matcher.matches();
    }
    public static void validateUserInput(
            final String userInput,
            final String regex,
            final String errorMessage) {
        final Matcher matcher = Pattern.compile(regex)
                .matcher(userInput);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void validateUniqueRacers(String[] racers) {
        Set<String> uniqueRacers = new HashSet<>(Arrays.asList(racers));
        if (uniqueRacers.size() != racers.length) {
            throw new NotUniqueDriverException();
        }
    }
}
