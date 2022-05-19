package be.iccbxl.pid.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

public interface IService<T> {

    List<T> findAll();

    Optional<T> findById(long id);

    T save(@Valid T t);

    T update(@Valid T t);

    long deleteById(long id);

}
