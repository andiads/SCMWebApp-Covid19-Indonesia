package code.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import code.java.Labs;
import code.java.repo.LabsRepository;

@Service
@Transactional
public class LabsService {
	
	@Autowired
	private LabsRepository repo;
	
	public List<Labs> listAll(){
		return repo.findAll();
	}

	public void save(Labs labs) {
		repo.save(labs);
	}
	
	public Labs get(long id) {
		return (Labs) repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}

}
