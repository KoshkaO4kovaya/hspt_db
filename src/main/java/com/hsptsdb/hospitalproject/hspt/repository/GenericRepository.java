package com.hsptsdb.hospitalproject.hspt.repository;


import com.hsptsdb.hospitalproject.hspt.model.GenericModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean // не даст создать репозиторий, т.к. он абстрактный. Аналог @MappedSuperclass у GenericModel
public interface GenericRepository<T extends GenericModel> extends JpaRepository<T, Long> { // Ограничиваем работу

    Page<T> findAllByIsDeletedFalse(Pageable pageable);
    List<T> findAllByIsDeletedFalse();

}