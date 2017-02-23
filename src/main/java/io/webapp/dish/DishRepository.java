package io.webapp.dish;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Integer> {
	public List<Dish> findByPrice(String price);
	public List<Dish> findByName(String name);
	public List<Dish> findById(Integer id);
	public List<Dish> findByType(String type);
}	
