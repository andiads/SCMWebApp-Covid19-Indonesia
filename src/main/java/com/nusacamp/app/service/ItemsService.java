package com.nusacamp.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.nusacamp.app.repository.ItemsRepository;
import com.nusacamp.app.model.Items;

@Service
@Transactional
public class ItemsService {
	
	@Autowired
	private ItemsRepository repo;
	
	public List<Items> listAll(){
		return repo.findAll();
	}
	
	public void save(Items item) {
		repo.save(item);
	}
	
	public Items get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}

}
