package io.webapp.dish;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Dish {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Integer id;
	
	@NonNull
	public String name;
	
	@NonNull
	public String price;
	
	@NonNull
	public String type;
	
	@Lob
	@NonNull
	public byte[] image;
	
	public Dish(byte[] image, String name, String price, String type ){
		this.name = name;
		this.price = price;
		this.type = type;
		this.image = image;
	}
}
