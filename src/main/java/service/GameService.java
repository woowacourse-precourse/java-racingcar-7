package service;

import static constant.GameSettings.MOVE_THRESHOLD;
import static constant.GameSettings.RANDOM_LOWER_BOUND;
import static constant.GameSettings.RANDOM_UPPER_BOUND;

import camp.nextstep.edu.missionutils.Randoms;
import model.Car;
import repository.CarRepository;

public class GameService {

    private final ResultService resultService;

    public GameService(ResultService resultService) {
        this.resultService = resultService;
    }

    public String playRounds(int rounds) {
        StringBuilder roundResults = new StringBuilder();

        for (int i = 0; i < rounds; i++) {
            playSingleRound();
            String raceResult = resultService.displayRace(CarRepository.getCars());
            roundResults.append(raceResult).append("\n\n");
        }
        return roundResults.toString();
    }

    private void playSingleRound() {
        CarRepository.getCars().forEach(this::moveCarIfEligible);
    }

    private void moveCarIfEligible(Car car) {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_LOWER_BOUND.getMessage(), RANDOM_UPPER_BOUND.getMessage());
        if (randomNumber >= MOVE_THRESHOLD.getMessage()) {
            car.move(randomNumber);
        }
    }
}
