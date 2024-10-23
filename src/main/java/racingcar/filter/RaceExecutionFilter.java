package racingcar.filter;

import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.executor.RaceExecutor;
import racingcar.model.CarList;

public class RaceExecutionFilter implements Filter<RaceRequest, RaceResponse> {
    private final RaceExecutor executor;

    public RaceExecutionFilter(RaceExecutor executor) {
        this.executor = executor;
    }

    @Override
    public void doFilter(RaceRequest request, RaceResponse response, RaceFilterChain chain) {
        CarList carList = request.getCarList();
        int iterations = request.getIterations();

        executor.executeRace(carList, iterations);

        chain.doFilter(request, response);
    }
}
