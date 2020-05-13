package code.java;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import code.java.service.LabsService;

@Controller
public class AppController {

	@Autowired
	private LabsService service;
	
	@RequestMapping("/")
	public String viewLab(Model model) {
		List<Labs> listLabs = service.listAll();
		model.addAttribute("listLabs", listLabs);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewLabPage(Model model) {
		Labs labs = new Labs();
		model.addAttribute("labs", labs);
		
		return "new_lab";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveLab(@ModelAttribute("labs") Labs labs) {
		service.save(labs);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditLab(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_lab");
		Labs labs = service.get(id);
		mav.addObject("labs", labs);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteLab(@PathVariable(name = "id") int id) {
		service.delete(id);
		
		return "redirect:/";
	}
	
	@RequestMapping("/labs")
	public List<Labs> list() {
	    return service.listAll();
	}
	
	@RequestMapping("/labs/{nama_lab}")
	public ResponseEntity<Labs> get(@PathVariable Integer id) {
	    try {
	        Labs labs = service.get(id);
	        return new ResponseEntity<Labs>(labs, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Labs>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/labs")
	public void add(@RequestBody Labs labs) {
	    service.save(labs);
	}
	
	@PutMapping("/labs/{id}")
	public ResponseEntity<?> update(@RequestBody Labs labs, @PathVariable Integer id) {
	    try {
	        Labs existLabs = service.get(id);
	        service.save(labs);
	        return new ResponseEntity<Labs>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Labs>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/labs/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
}
