package racingcar.filter;

import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.exception.InvalidCommandException;
import racingcar.exception.NegativeIterationException;

public class RaceInputValidationFilter implements Filter<RaceRequest, RaceResponse> {

    private static final String COMMAND_REGEX = "^(?!,)([^,]+)(,(?!$)[^,]+)*$";

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

    private void validateIterations(Integer tryCount) {
        if (tryCount < 0) {
            throw new NegativeIterationException();
        }
    }
}
