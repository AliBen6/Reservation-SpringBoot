package be.iccbxl.pid.resource;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {

    List<T> findAll();

    Optional<T> findById(long id);

    long deleteById(long id);

    T save(T t);

    Boolean existsById(long id);

}