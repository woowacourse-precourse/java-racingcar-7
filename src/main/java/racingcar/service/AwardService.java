package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.domain.Round;
import racingcar.domain.ScoreEntry;
import racingcar.repository.CarRepository;
import racingcar.repository.GameRepository;
import racingcar.view.Output;

public class AwardService {

    private final CarRepository carRepository = CarRepository.getInstance();
    private final GameRepository gameRepository = GameRepository.getInstance();
    private final Output output;

    public AwardService(Output output){
        this.output = output;
    }

    public void presentAward(Integer gameId){
        Game game = gameRepository.findByGameId(gameId);

        Integer roundCount = game.getRoundCount();
        Round round = game.getRoundList().get(roundCount-1);
        List<String> winnerNames = extractWinners(round.getScoreBoard());

        List<Car> winnerList = new ArrayList<>();
        for(String winnerName : winnerNames){
            Car winner = carRepository.findByCarName(winnerName);
            winnerList.add(winner);
        }

        game.setWinnerList(winnerList);
        gameRepository.save(game);

        output.printWinners(winnerList);
    }

    private List<String> extractWinners(List<ScoreEntry> finalScoreBoard) {
        Integer championForwardCount = finalScoreBoard.getFirst().getForwardCount();

        return finalScoreBoard.stream()
                .filter(entry -> entry.getForwardCount().equals(championForwardCount))
                .map(ScoreEntry::getCarName)
                .collect(Collectors.toList());
    }
}
