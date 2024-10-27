package racingcar.filter;

import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.filter.executor.RaceExecutor;
import racingcar.model.CarList;

public class RaceExecutionFilter implements Filter<RaceRequest, RaceResponse> {
    private final RaceExecutor executor;

    public RaceExecutionFilter(RaceExecutor executor) {
        this.executor = executor;
    }

    @Override
    public RaceResponse doFilter(RaceRequest request, RaceFilterChain chain) {
        CarList carList = request.carList();
        int iterations = request.iterations();

        executor.executeRace(carList, iterations);

        return chain.doFilter(request);
    }
}
