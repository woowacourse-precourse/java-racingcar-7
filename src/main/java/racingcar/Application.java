
package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.Controller.MoveProcessController;
import racingcar.service.MoveService;

public class Application {

    public static void main(String[] args) {
        MoveProcessController controller = new MoveProcessController();
        controller.raceStart();
    }
}