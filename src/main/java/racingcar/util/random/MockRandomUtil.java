package racingcar.util.random;

import racingcar.common.config.AppConfig;

public class MockRandomUtil implements IRandomUtil {
    @Override
    public int generateRandomNum() {
        return AppConfig.getTestProfileSettingValue();
    }
}
