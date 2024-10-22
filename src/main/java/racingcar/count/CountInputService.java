package racingcar.count;

import racingcar.utils.IOUtils;

public class CountInputService {
    CountInputValidator countInputValidator;

    public CountInputService(CountInputValidator countInputValidator) {
        this.countInputValidator = countInputValidator;
    }

    public String getAttemptCount() {
        IOUtils.outputStringWithEnter("시도할 횟수는 몇 회인가요?");
        String attemptCount = IOUtils.input();

        countInputValidator.checkIsAttemptCountValid(attemptCount);

        return attemptCount;
    }
}
