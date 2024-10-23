package repository;

import java.util.Map;

public class CarRepository implements Repository{
    private final Map<String, Long> carRepository;

    public CarRepository(Map<String, Long> carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * 중복이름 검사
     * @param name : 자동차 이름
     * @return : 중복데이터가 존재하면 true
     */
    @Override
    public Boolean isDuplicateName(String name){
        return carRepository.containsKey(name);
    }

    @Override
    public void save(String name, Long moveForwardCount) {
        carRepository.put(name, moveForwardCount);
    }

    @Override
    public Long find(String name) {
        return carRepository.get(name);
    }

}
