package racingcar.common.config;

import static java.util.Objects.nonNull;
import static racingcar.common.constant.SystemConstant.TEST_PROFILE;

public class AppConfig {
    public static boolean isTestProfile() {
        String profile = System.getProperty("test");
        return nonNull(profile);
    }

    public static void setTestProfileWithValue(String value) {
        System.setProperty(TEST_PROFILE, value);
    }

    public static int getTestProfileSettingValue() {
        String value = System.getProperty(TEST_PROFILE);
        return Integer.parseInt(value);
    }

    public static void resetProfile() {
        System.clearProperty(TEST_PROFILE);
    }

    private AppConfig() {
    }
}
