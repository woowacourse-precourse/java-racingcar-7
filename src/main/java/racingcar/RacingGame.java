package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame
{
    private List<Player> players;
    private int numberOfRounds;

    public RacingGame(String[] carNames, int numberOfRounds)
    {
        this.players = new ArrayList<>();
        for (String name : carNames)
        {
            this.players.add(new Player(name));
        }
        this.numberOfRounds = numberOfRounds;
    }

    public void start()
    {
        for (int i = 0; i < numberOfRounds; i++)
        {
            race();
            OutputView.printRoundResult(players);
        }
        OutputView.printWinners(getWinners());
    }

    private void race() {
        for (Player player : players)
        {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4)
            {
                player.move();
            }
        }
    }

    private List<String> getWinners()
    {
        int maxPosition = players.stream()
                .mapToInt(Player::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("우승자가 없습니다."));

        List<String> winners = new ArrayList<>();
        for (Player player : players)
        {
            if (player.getPosition() == maxPosition)
            {
                winners.add(player.getName());
            }
        }
        return winners;
    }
}
