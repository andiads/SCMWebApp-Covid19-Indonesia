package com.nusacamp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nusacamp.app.model.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
