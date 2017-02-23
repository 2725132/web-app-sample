package io.webapp.dish;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.webapp.dish.exception.DishNotFoundException;

@Service
public class DishService {

	@Autowired
	private DishRepository repository;

	private List<Dish> dishes = new ArrayList<Dish>();


	public List<Dish> getAllDishes() {
		repository.findAll().forEach(dishes::add);
		return dishes;
	}

	public List<Dish> findById(String id) {
		return repository.findById(Integer.valueOf(id));
	}

	public List<Dish> findByName(String name) {
		return repository.findByName(name);
	}

	public List<Dish> findByType(String type) {
		return repository.findByType(type);
	}
	
	public List<Dish> findByPrice(String price) {
		return repository.findByPrice(price);
	}
	
	public void addDish(List<Dish> dishes) {
		dishes.forEach((dish) -> repository.save(dish));
	}

	public void deleteDish(Integer id) {
		if (repository.exists(id))
			repository.delete(id);

	}

	public void saveMockDishes() {
		repository.save(new Dish(new byte[999], "água", "1 real", "bebida" ));
		repository.save(new Dish( new byte[9999],"coca-cola", "5 reais", "bebida"));
		repository.save(new Dish( new byte[9999],"vinho português", "100 real", "bebida"));
	}

	public void updateDish(Integer id, Dish dish) {
		if (repository.exists(id)) {
			dish.setId(id);
			repository.save(dish);
		}

	}

	public List<Dish> getDish(String property, String attribute) throws NoSuchMethodException {
		String propertyCapitalized = property.substring(0, 1).toUpperCase() + property.substring(1);
		try {
	
			
			Method methodToBeExecute = Class.forName(this.getClass().getName())
					.getMethod("findBy" + propertyCapitalized, String.class);
			
			// System.out.println(methodToBeExecute.getName() + " ####### " +
			// methodToBeExecute.getDeclaringClass().getName());
			
			@SuppressWarnings("unchecked")
			List<Dish> dishes = (List<Dish>) methodToBeExecute.invoke(this, attribute);
			
			if(dishes == null || dishes.isEmpty()) throw new DishNotFoundException(methodToBeExecute.getName() , attribute);
			else return dishes;
			
		} catch (SecurityException | ClassNotFoundException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
		
			e.printStackTrace();
		}
		return null;
	}
	
	
	

}
