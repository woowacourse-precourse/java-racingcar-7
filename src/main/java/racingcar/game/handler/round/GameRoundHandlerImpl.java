package racingcar.game.handler.round;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.Car;
import racingcar.context.GameContext;
import racingcar.event.manager.EventPubSubManager;
import racingcar.game.Game;

public class GameRoundHandlerImpl implements GameRoundHandler{

    @Override
    public void handle() {

        Game game = (Game) GameContext.getAttribute(Game.class);
        for (Car car : game.getCars()) {
            if (Randoms.pickNumberInRange(0, 9) > 3) {
                car.setPosition(car.getPosition() + 1);
            }
        }
        EventPubSubManager.publish(Game.GameEvent.ROUND_END);
    }

}
