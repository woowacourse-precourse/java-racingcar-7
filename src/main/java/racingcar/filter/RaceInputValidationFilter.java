package racingcar.filter;

import racingcar.common.exception.InvalidCommandException;
import racingcar.common.exception.NegativeIterationException;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;

public class RaceInputValidationFilter implements Filter<RaceRequest, RaceResponse> {
    private static final String COMMAND_REGEX = "^(?!\\s*$)([^,]+)(,(?!$)[^,]+)*$";

    @Override
    public RaceResponse doFilter(RaceRequest request, RaceFilterChain chain) {
        validateRequest(request);
        return chain.doFilter(request);
    }

    private void validateRequest(RaceRequest request) {
        validateCommand(request.command());
        validateIterations(request.iterations());
    }

    private void validateCommand(String command) {
        if (!command.matches(COMMAND_REGEX)) {
            throw new InvalidCommandException();
        }
    }

    private void validateIterations(Integer iterations) {
        if (iterations < 0) {
            throw new NegativeIterationException();
        }
    }
}
