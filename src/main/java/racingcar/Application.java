package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static final String lastPrefix = "최종 우승자 : ";

    public static void main(String[] args) throws IllegalArgumentException {
        final PrintWriter pw = new PrintWriter(System.out);
        String line;

        line = readLine();
        if (line == null || line.isBlank()) {
                throw new IllegalArgumentException();
        }
        final String[] carNames = line.split(",");
        final List<RacingCar> racingCars = Arrays.stream(carNames)
                .parallel()
                .map(String::trim)
                .map(RacingCar::new)
                .collect(Collectors.toCollection(ArrayList::new));
        
        racingCars.parallelStream()
                        .allMatch(racingCar -> racingCar.getName().length() <= 5);

        line = readLine();
        if (line == null || line.isBlank()) {
                throw new IllegalArgumentException();
        }
        final int numRounds = Integer.parseInt(line.trim());
        for (int i = 0; i != numRounds; i++) {
            racingCars.stream()
                    .forEach(
                        racingCar -> {
                            racingCar.move();
                            pw.println(racingCar.getName() + " : " + "-".repeat(racingCar.getMileage()));
                        }
                    );
            
            pw.println();
            pw.flush();
        }

        final int maxMileage = racingCars.parallelStream()
                .max(Comparator.comparing(RacingCar::getMileage))
                .get()
                .getMileage();
        pw.println(lastPrefix + racingCars.stream()
                .filter(racingCar -> racingCar.getMileage() == maxMileage)
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "))
        );
        pw.flush();
    }
}
