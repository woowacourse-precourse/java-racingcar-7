package racingcar.count;

import racingcar.utils.IOUtils;

public class CountService {
    CountValidator countValidator;

    public CountService(CountValidator countValidator) {
        this.countValidator = countValidator;
    }

    public String getAttemptCount() {
        IOUtils.outputString("시도할 횟수는 몇 회인가요?");
        String attemptCount = IOUtils.input();
        countValidator.checkIsAttemptCountValid(attemptCount);
        return IOUtils.input();
    }
}
