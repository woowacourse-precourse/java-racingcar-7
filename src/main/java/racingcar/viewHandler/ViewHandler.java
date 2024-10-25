package racingcar.viewHandler;

import racingcar.dto.InputDto;
import racingcar.dto.RoundDto;
import racingcar.viewHandler.api.Api;
import racingcar.view.Input;
import racingcar.view.Output;
import racingcar.viewHandler.api.message.ExceptionMessageImpl;

import java.util.List;

public class ViewHandler {
    private final ApiHandler apiHandler;
    private final Input input;
    private final Output output;

    protected ViewHandler() {
        apiHandler = ApiHandler.of();
        input = Input.of();
        output = Output.of();
    }

    public static ViewHandler of() {
        return new ViewHandler();
    }

    public Api<InputDto> inputHandler() {
        try {
            return dataHandler();
        } catch (ExceptionMessageImpl e) {
            output.viewException(new Api(e));
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void outputHandler(Api api) {
        if(api.getCode() == 200) {
            viewHandler(api);
        } else {
            output.viewException(api);
            throw new IllegalArgumentException(api.getMessage());
        }
    }

    private Api<InputDto> dataHandler() {
        String getCarnames = input.getStringCarnames();
        List<String> carnames = apiHandler.splitCarnames(getCarnames);
        String getTotalRound = input.getStringTotalRound();
        Integer totalRound = apiHandler.parserTotalRound(getTotalRound);

        return apiHandler.transformInputDto(carnames, totalRound);
    }

    private void viewHandler(Api api) {
        if(api.getData() instanceof RoundDto){
            output.viewOneRound(api);
        } else if(api.getData() instanceof String) {
            output.viewResult(api);
        }
    }
}
