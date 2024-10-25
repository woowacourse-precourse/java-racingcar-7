package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Game;
import racingcar.domain.Input;

public class GameService {

    private Game game;
    private static Input input;

    public GameService(Input input, Game game) {
        GameService.input = input;
        this.game = game;
    }

    public void addCarName() {
        String[] names = input.getNames().split(",");

        for (String name : names) {
            if (game.getCars().containsKey(name)) throw new IllegalArgumentException("중복된 이름입니다.");

            game.getCars().put(name, 0);
        }

        runCarGame();
    }

    public void runCarGame() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.getCount(); i++) {
            for (String car : game.getCars().keySet()) {
                int random = Randoms.pickNumberInRange(0, 9);
                int distance = game.getCars().get(car);

                if (random >= 4) game.getCars().put(car, distance + 1);

                sb.append(car).append(" : ");
                for (int j = 0; j < distance; j++) {
                    sb.append('-');
                }
                sb.append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}
