package racingcar.service;

import racingcar.util.DataTransformUtil;
import racingcar.util.ValidationUtil;

public class RegisterExecutionNumberService {

    private final ValidationUtil validationUtil;
    private final DataTransformUtil dataTransformUtil;

    public RegisterExecutionNumberService(ValidationUtil validationUtil, DataTransformUtil dataTransformUtil) {
        this.validationUtil = validationUtil;
        this.dataTransformUtil = dataTransformUtil;
    }

    public int registerExecutionNumber(final String executionNumberInput) {
        isValidExecutionNumber(executionNumberInput);
        return dataTransformUtil.parseToInt(executionNumberInput);
    }

    private boolean isValidExecutionNumber(final String executionNumberInput){
        validationUtil.isNumber(executionNumberInput);
        validationUtil.isValidExecutionRange(executionNumberInput);
        return true;
    }
}
