package repository;

public interface Repository {
    Boolean isDuplicateName(String name);

    void save(String name,Long moveForwardCount);

    Long find(String name);

    int size();


}
