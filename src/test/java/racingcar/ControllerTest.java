package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.Controller;
import racingcar.dto.RaceRequest;
import racingcar.exceptions.InvalidInputException;
import racingcar.factory.controller.ControllerFactory;
import racingcar.factory.controller.ControllerType;
import racingcar.view.RaceView;


public class ControllerTest {

    private ControllerFactory controllerFactory = new ControllerFactory();

    @Test
    void 프록시_유효성_검사_1() {
        Controller<RaceRequest> controller = controllerFactory.create(ControllerType.RACE);
        RaceRequest request = new RaceRequest(",a,", 3);
        Assertions.assertThrows(InvalidInputException.class, () -> {
            controller.run(request);
        });
    }

    @Test
    void 프록시_유효성_검사_2() {
        Controller<RaceRequest> controller = controllerFactory.create(ControllerType.RACE);
        RaceRequest request = new RaceRequest("a,b,a", 1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller.run(request);
        });
    }

    @Test
    void 프록시_유효성_검사_3() {
        Controller<RaceRequest> controller = controllerFactory.create(ControllerType.RACE);
        RaceRequest request = new RaceRequest("", 1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller.run(request);
        });
    }

    @Test
    void 뷰_반환_확인() {
        Controller<RaceRequest> controller = controllerFactory.create(ControllerType.RACE);
        RaceRequest request = new RaceRequest("a,b,c", 1);
        Assertions.assertEquals(RaceView.class, controller.run(request).getClass());
    }

    @Test
    void NPE_발생_확인() {
        Controller<RaceRequest> controller = controllerFactory.create("Unknown");
        RaceRequest request = new RaceRequest("a,b,c", 1);
        Assertions.assertThrows(NullPointerException.class, () -> {
            controller.run(request);
        });
    }
}
