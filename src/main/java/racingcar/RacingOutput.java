package racingcar;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The class {@code RacingOutput} has method about displaying game progresses.
 */
public class RacingOutput {
    /**
     * Display the car's name and position visually in the console.
     *
     * @param carDtos a list of CarDto
     */
    public void displayRaceProgress(List<CarDto> carDtos) {
        String raceProgress = carDtos.stream()
                .map(CarDto::toString)
                .collect(Collectors.joining());
        System.out.println(raceProgress);
    }

    /**
     * Display the winner.
     *
     * @param winners a List of String
     */
    public void displayWinner(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
