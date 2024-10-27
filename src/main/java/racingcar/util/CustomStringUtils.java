package racingcar.util;

import racingcar.domain.RacingCar;

import java.util.List;

public abstract class CustomStringUtils {

    public static void printStringLineFeed(String str) {
        System.out.print(str.concat("\n"));
    }

    public static void printFinalWinners(List<String> winners) {
        String winner = String.join(", ", winners);
        System.out.print(ConstantVariables.FINAL_WINNER.value().concat(winner).concat("\n"));
    }

    public static void printRoundStatus(List<RacingCar> carList) {
        StringBuilder sb = new StringBuilder();

        for (RacingCar car : carList) {
            sb.append(car.getName().concat(" : ").concat("-".repeat(car.getPosition())).concat("\n"));
        }
        System.out.println(sb);
    }
}