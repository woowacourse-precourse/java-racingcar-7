package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import racingcar.game.Game;
import racingcar.notice.Notice;
import racingcar.player.Player;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Predicate<String>> policies = List.of(
                (name) -> name.length() <= 5
        );
        List<String> names = Notice.inputName(Console::readLine, policies);
        Integer gameTime = Notice.inputGameTime(Console::readLine);

        List<Player> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name));
        }

        // 중복된 이름이 있는지 검증
        if(players.size() != players.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다");
        }

        Game game = new Game(players);

        for(int i = 0; i < gameTime; i++) {
            List<Player> playerList = game.play(1, (player) -> 4 <= Randoms.pickNumberInRange(0, 9));
            playerList.forEach(player -> {
                        System.out.println(player.current());
            });
        }

        List<String> winner = game.winner();
        System.out.print("최종 우승자 : ");
        if(winner.size() == 1) {
            System.out.println(winner.getFirst());
        } else {
            System.out.println(String.join(", ", winner));
        }
    }
}
