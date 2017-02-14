package io.webapp.dish;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Integer> {
	public List<Dish> findByPrice(String price);
}	
