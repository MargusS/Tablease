package com.tablease.menu.domain;

import java.time.Instant;
import java.util.UUID;

import com.tablease.menu.domain.VO.Destination;

public class DishType {

	private final UUID uuid;
	private String name;
	private Destination preparationArea;
	private final Instant createdAt;
	private Instant updatedAt;

	public DishType(UUID uuid, String name, Destination preparationArea) {
		dishTypeValidation(uuid, name, preparationArea);
		this.uuid = uuid;
		this.name = name.trim();
		this.preparationArea = preparationArea;
		this.createdAt = Instant.now();
		this.updatedAt = this.createdAt;
	}

	public void update(UUID uuid, Destination preparationArea) {
		dishTypeValidation(uuid, name, preparationArea);

		this.name = name.trim();
		this.preparationArea = preparationArea;
		this.updatedAt = Instant.now();
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public Destination getPreparationArea() {
		return preparationArea;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	private void dishTypeValidation(UUID uuid, String name, Destination preparationArea) {
		if (uuid == null)
			throw new IllegalArgumentException("DishType UUID cannot be null");
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("DishType name cannot be null or empty");
		}
		if (preparationArea == null) {
			throw new IllegalArgumentException("Preparation area is required");
		}
	}

}
