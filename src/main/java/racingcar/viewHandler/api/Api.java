package racingcar.viewHandler.api;

import racingcar.viewHandler.api.message.ApiMessage;

public class Api<T> {
    private final ApiMessage apiMessage;
    private final T data;

    public Api(ApiMessage apiMessage , T data) {
        this.apiMessage = apiMessage;
        this.data = data;
    }

    public Api(ApiMessage apiMessage) {
        this.apiMessage = apiMessage;
        data = null;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return apiMessage.getMessage();
    }

    public Integer getCode() {
        return apiMessage.getCode();
    }
}
