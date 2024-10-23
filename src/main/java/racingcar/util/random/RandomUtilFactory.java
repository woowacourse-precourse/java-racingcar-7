package racingcar.util.random;

import static racingcar.common.config.AppConfig.isTestProfile;

public class RandomUtilFactory {
    //FIXME : 약감 꼼수. 대안책 필히 찾아봐야 함.
    public static IRandomUtil getUtil() {
        if (isTestProfile()) {
            return new MockRandomUtil();
        }
        return new RandomUtil();
    }
}
