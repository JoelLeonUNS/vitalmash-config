package com.sistemas.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistemas.api.dominio.*;

@Repository
public interface LoteRepository extends JpaRepository<LoteDetalle, Long>{

}