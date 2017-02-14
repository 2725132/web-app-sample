package io.webapp.dish;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishService {
	
	@Autowired
	private DishRepository repository;
	
	private List<Dish> dishes = new ArrayList<Dish>();
	
	public List<Dish> getAllDishes(){
		repository.findAll().forEach(dishes :: add);
		return dishes;
	}
	
	public Dish getDishById(Integer id){
		return repository.findOne(id);
	}
	
	public void addDish(List<Dish> dishes){
		dishes.forEach((dish) -> repository.save(dish));
	}

	public void deleteDish(Integer id) {
		if(repository.exists(id)) repository.delete(id);

	}
	
	public void saveMockDishes(){
		repository.save(new Dish("água", "1 real", "bebida"));
		repository.save(new Dish("coca-cola", "5 reais", "bebida"));
		repository.save(new Dish("vinho português", "100 real", "bebida"));
	}


	public void updateDish(Integer id, Dish dish){
		if(repository.exists(id)){
			dish.setId(id);
			repository.save(dish);
		}
		
			
	}


}
