package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        final PrintWriter pw = new PrintWriter(System.out);

        final int numUsers = Integer.parseInt(readLine());

        final List<RacingCar> racingCars = Stream.generate(RacingCar::new)
                .limit(numUsers)
                .collect(Collectors
                        .toCollection(ArrayList::new));

        for (int i = 0; i != numUsers; i++) {
            racingCars.parallelStream()
                    .forEach(RacingCar::move);

            racingCars.stream()
                    .forEach(racingCar ->
                        pw.println("-".repeat(racingCar.getMileage()))
                    );

            pw.flush();
        }
    }
}
