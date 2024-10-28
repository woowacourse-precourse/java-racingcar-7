package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.domain.Round;
import racingcar.domain.ScoreEntry;
import racingcar.repository.CarRepository;
import racingcar.repository.GameRepository;
import racingcar.repository.RoundRepository;
import racingcar.view.Output;

public class GameService {

    private final CarRepository carRepository = CarRepository.getInstance();
    private final RoundRepository roundRepository = RoundRepository.getInstance();
    private final GameRepository gameRepository = GameRepository.getInstance();
    private final Output output;

    public GameService(Output output){
        this.output = output;
    }

    public Integer startGame(List<String> carNames, int roundCount) {

        Game game = new Game.Builder()
                .roundCount(roundCount)
                .build();

        Integer gameId = gameRepository.saveAndReturnId(game);
        List<Car> carList = saveCarNames(carNames);

        System.out.println("실행 결과");
        for(int thisRound=1;thisRound<=roundCount;thisRound++){
            Round round = new Round.Builder()
                    .thisRound(thisRound)
                    .gameId(gameId)
                    .carList(carList)
                    .build();

            processRound(round);
            saveScore(round);
            roundRepository.save(round);

        output.outputRoundProcess(round.getScoreBoard());
            game.addRound(round);
        }

        gameRepository.update(game);
        return game.getId();
    }

    private List<Car> saveCarNames(List<String> carNames) {
        List<Car> carList = new ArrayList<>();

        for (String name : carNames) {
            Car car = new Car(name);
            carRepository.save(car);
            carList.add(car);
        }

        return carList;
    }

    private void processRound(Round round){
        for(Car car : round.getCarList()){
            tryForward(car);
        }
    }

    private void tryForward(Car car){
        Integer random = Randoms.pickNumberInRange(0,9);
        if(random >= 4){
            car.goForward();
        }
    }

    private void saveScore(Round round){
        for(Car car : round.getCarList()){
            ScoreEntry scoreEntry = new ScoreEntry(car.getName(), car.getForwardCount());
            round.addScoreEntry(scoreEntry);
        }

        round.getScoreBoard().sort(Comparator.comparing(ScoreEntry::getForwardCount).reversed());

        for (int rank = 0; rank < round.getScoreBoard().size(); rank++) {
            round.getScoreBoard().get(rank).setRank(rank + 1);
        }
    }
}
