package io.webapp.dish;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/dish")
public class DishController {
	@Autowired
	public DishService service;
	
	@RequestMapping("/")
	public List<Dish> getDishes(){
		return service.getAllDishes();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/add")
	public String addDish(@RequestBody List<Dish> dish){
		service.addDish(dish);
		return "adicionado!";
	}
	

	
	@RequestMapping(method=RequestMethod.GET, value="/find/{findBy}/{attribute}")
	public List<Dish> getDish(@PathVariable String findBy , @PathVariable String attribute) throws NoSuchMethodException{
		return service.getDish(findBy, attribute);
	}
	

	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
	public String deleteDish(@PathVariable Integer id){
		service.deleteDish(id);
		return "Prato com id " + id + " deletado com sucesso!";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
	public String updateDish(@RequestBody Dish dish, @PathVariable Integer id){
		service.updateDish(id, dish);
		return "informações do prato \"" + dish.getName() + "\" atualizadas com sucesso";
	}
	
	@RequestMapping(value="/addtest")
	public String addTestDishes(){
		service.saveMockDishes();
		return "pratos salvos com sucesso!";
	}
	
	


}
