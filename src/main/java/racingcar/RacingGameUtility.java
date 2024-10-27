package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameUtility {

    public static void moveRacingCar(RacingCar car) {
        if(Randoms.pickNumberInRange(0, 9) >= 4) {
            car.raiseMoveCount();
        }
    }

    public static void checkNameLength(String input) {
        if(input.isEmpty() || input.length() > 5) {
            throw new IllegalArgumentException(input + " ::: 이름은 5자 이하만 가능합니다.");
        }
    }

    public static List<String> splitStringToArray(String input, String delimiter) {
        String[] list = input.split(delimiter);

        Arrays.stream(list).forEach(RacingGameUtility::checkNameLength);

        return Arrays.stream(list).collect(Collectors.toList());
    }

    public static List<RacingCar> generateRacingCar(List<String> nameList) {
        List<RacingCar> carList = new ArrayList<>();
        nameList.forEach(str -> {
            carList.add(new RacingCar(str));
        });

        return carList;
    }

    public static String getResultMessage(List<RacingCar> carList) {
        int max = carList.stream().mapToInt(RacingCar::getMoveCount).filter(count -> count >= 0).max().orElse(0);
        List<RacingCar> winner = carList.stream().filter(racingCar -> racingCar.getMoveCount() == max).toList();

        String result = winner.stream().map(RacingCar::getName).collect(Collectors.joining(", "));

        return "최종 우승자 : " + result.trim();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
