package com.mysql.springbootwithmysql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysql.springbootwithmysql.db.Peserta;


@Repository
public interface PesertaRepo extends JpaRepository<Peserta, Long> {

}
