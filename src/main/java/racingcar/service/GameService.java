package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Game;
import racingcar.domain.Input;
import racingcar.view.GameView;

public class GameService {

    private Input input;
    private static Game game;
    private static int max;

    public GameService(Input input, Game game) {
        this.input = input;
        this.game = game;
    }

    public void run() {
        addCarName(input.getNames());
        GameView.displayGameProgress(input.getCount(), this);
    }

    public static void addCarName(String strings) {
        String[] names = strings.split(",");

        for (String name : names) {
            if (game.getCars().containsKey(name)) {
                throw new IllegalArgumentException("중복된 이름입니다.");
            }
            game.getCars().put(name, 0);
        }
    }

    public String runCarGame() {
        StringBuilder sb = new StringBuilder();
        for (String car : game.getCars().keySet()) {

            int random = Randoms.pickNumberInRange(0, 9);
            int distance = game.getCars().get(car);

            if (random >= 4) {
                game.getCars().put(car, distance + 1);
                max = Math.max(max, game.getCars().get(car));
            }

            sb.append(car).append(" : ");
            for (int i = 0; i < game.getCars().get(car); i++) {
                sb.append('-');
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    public static String getWinner() {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        for (String car : game.getCars().keySet()) {
            if (game.getCars().get(car) == max) {
                sb.append(car).append(", ");
            }
        }
        return sb.substring(0, sb.toString().length() - 2);
    }
}
