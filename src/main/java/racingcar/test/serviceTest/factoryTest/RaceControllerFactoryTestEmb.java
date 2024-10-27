package racingcar.test.serviceTest.factoryTest;

import org.junit.jupiter.api.Test;
import racingcar.controller.race.RaceController;
import racingcar.service.factory.RaceControllerFactory;
import racingcar.service.factory.RaceControllerFactoryEmb;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceControllerFactoryTestEmb implements RaceControllerFactoryTest {
    @Test
    public void testCreateRaceController() {
        RaceControllerFactory raceControllerFactory = new RaceControllerFactoryEmb();
        assertThat(raceControllerFactory.createRaceController()).isNotNull();
        assertThat(raceControllerFactory.createRaceController()).isInstanceOf(RaceController.class);
    }
}
