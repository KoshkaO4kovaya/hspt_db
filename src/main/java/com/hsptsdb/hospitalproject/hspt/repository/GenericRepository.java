package com.hsptsdb.hospitalproject.hspt.repository;


import com.hsptsdb.hospitalproject.hspt.model.GenericModel;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.awt.print.Pageable;
import java.util.List;

@NoRepositoryBean
public interface GenericRepository <T extends GenericModel> extends JpaRepository<T, Long> {

}
