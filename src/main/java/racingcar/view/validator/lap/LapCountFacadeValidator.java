package racingcar.view.validator.lap;

public class LapCountFacadeValidator {

    public static void validateLapCount(String source) {
        LapCountNullValidator lapCountNullValidator = LapCountNullValidator.initiate();
        LapRegexValidator regexValidator = LapRegexValidator.initiate();
        NumberFormatValidator formatValidator = NumberFormatValidator.initiate();

        lapCountNullValidator
                .doChain(regexValidator)
                .doChain(formatValidator);

        lapCountNullValidator.check(source);
    }
}
