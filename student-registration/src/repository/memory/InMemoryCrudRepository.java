package repository.memory;

import domain.Identifiable;
import repository.CrudRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryCrudRepository<T extends Identifiable> implements CrudRepository<T> {
    private final Map<Integer, T> storage;

    public InMemoryCrudRepository() {
        this.storage = new HashMap<>();
    }

    @Override
    public void save(T entity) {
        storage.put(entity.getId(), entity);
    }

    @Override
    public Optional<T> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void update(T entity) {
        storage.put(entity.getId(), entity);
    }

    @Override
    public void deleteById(int id) {
        storage.remove(id);
    }
}
