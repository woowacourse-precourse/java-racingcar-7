package racingcar.validation;

public class ValidationRequest<T> {
    private T validationRequestingObject;

    public ValidationRequest(T validationRequestingObject) {
        this.validationRequestingObject = validationRequestingObject;
    }

    public T getObject() {
        return validationRequestingObject;
    }
}
