package racingcar.view.validator.car;

public class CarNameFacadeValidator {

    private CarNameFacadeValidator() {
    }

    public static void validateCarNames(String source) {
        CarNameNullValidator carNameNullValidator = CarNameNullValidator.initiate();
        CarCountValidator countValidator = CarCountValidator.initiate();
        CarNameLengthValidator lengthValidator = CarNameLengthValidator.initiate();

        carNameNullValidator
                .doChain(countValidator)
                .doChain(lengthValidator);

        carNameNullValidator.check(source);
    }

}
