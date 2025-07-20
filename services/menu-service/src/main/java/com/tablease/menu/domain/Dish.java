package com.tablease.menu.domain;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.tablease.menu.domain.VO.CostPrice;
import com.tablease.menu.domain.VO.SellingPrice;

public class Dish {

	private final UUID uuid;
	private String name;
	private String description;
	private SellingPrice price;
	private CostPrice cost;
	private DishType dishType;
	private List<Allergen> allergens;
	private boolean isActive;
	private String thumbnail;
	private final Instant createdAt;
	private Instant updatedAt;

	public Dish(UUID uuid, String name, String description, SellingPrice price, CostPrice cost, DishType dishType,
			List<Allergen> allergens, String thumbnail) {

		validateDish(uuid, name, description, dishType);

		this.uuid = uuid;
		this.name = name.trim();
		this.description = (description != null) ? description.trim() : null;
		this.price = price;
		this.cost = cost;
		this.dishType = dishType;
		this.allergens = List.copyOf(allergens);
		this.thumbnail = (thumbnail != null && !thumbnail.isBlank()) ? thumbnail.trim() : null;
		this.isActive = true;
		this.createdAt = Instant.now();
		this.updatedAt = this.createdAt;
	}

	public void deactivate() {
		this.isActive = false;
		this.updatedAt = Instant.now();
	}

	public boolean hasSamePriceAndCost(SellingPrice price, CostPrice cost) {
		return this.price.getAmount().equals(price.getAmount()) && this.cost.getAmount().equals(cost.getAmount());
	}

	public void update(UUID uuid, String name, String description, DishType dishType, List<Allergen> allergens,
			String thumbnail,
			boolean isActive) {
		validateDish(uuid, name, description, dishType);

		this.name = name.trim();
		this.description = (description != null) ? description.trim() : null;
		this.dishType = dishType;
		this.allergens = List.copyOf(allergens);
		this.thumbnail = (thumbnail != null && !thumbnail.isBlank()) ? thumbnail.trim() : null;
		this.isActive = isActive;
		this.updatedAt = Instant.now();
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public SellingPrice getPrice() {
		return price;
	}

	public CostPrice getCost() {
		return cost;
	}

	public DishType getDishType() {
		return dishType;
	}

	public List<Allergen> getAllergens() {
		return allergens;
	}

	public boolean isIsActive() {
		return isActive;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	private void validateDish(UUID uuid, String name, String description, DishType dishType) {
		if (uuid == null)
			throw new IllegalArgumentException("Dish UUID cannot be null");
		if (name == null || name.isBlank())
			throw new IllegalArgumentException("Dish name cannot be null or empty");
		if (description != null && description.length() > 400)
			throw new IllegalArgumentException("Description is too long");
		if (dishType == null)
			throw new IllegalArgumentException("Dish type is required");
	}
}
