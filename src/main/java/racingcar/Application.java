package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        final PrintWriter pw = new PrintWriter(System.out);

        final String[] carNames = readLine().split(",");
        final List<RacingCar> racingCars = Arrays.stream(carNames)
                .parallel()
                .map(RacingCar::new)
                .collect(Collectors.toCollection(ArrayList::new));

        final int numRounds = Integer.parseInt(readLine());
        for (int i = 0; i != numRounds; i++) {
            racingCars.parallelStream()
                    .forEach(racingCar -> racingCar.move(pickNumberInRange(0, 9)));

            racingCars.stream()
                    .forEach(racingCar ->
                        pw.println(racingCar.getName() + " : " + "-".repeat(racingCar.getMileage()))
                    );
            
            pw.println();
            pw.flush();
        }
    }
}
