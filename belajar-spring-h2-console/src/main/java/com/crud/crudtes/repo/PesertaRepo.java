package com.crud.crudtes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.crudtes.db.Peserta;

@Repository
public interface PesertaRepo extends JpaRepository<Peserta, Long> {

}
