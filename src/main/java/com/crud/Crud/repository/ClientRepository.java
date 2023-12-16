package com.crud.Crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.Crud.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}