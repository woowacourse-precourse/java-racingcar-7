package racingcar.config;

import racingcar.RacingCarLauncher;
import racingcar.manager.RacingManager;

public class AppConfig {

    public RacingCarLauncher racingCarLauncher(){
        RacingManager racingManager = new RacingManager();
        return new RacingCarLauncher(racingManager);
    }

}
