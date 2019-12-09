package com.serv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serv.model.Ordem;

public interface OrdemRepository extends JpaRepository<Ordem, Integer> {

}
