package com.tablease.menu.domain;

import java.time.Instant;
import java.util.UUID;

public class Allergen {

	private final UUID uuid;
	private String name;
	private String symbolUrl;
	private String description;
	private final Instant createdAt;
	private Instant updatedAt;

	public Allergen(UUID uuid, String name, String symbolUrl, String description) {
		validateAllergen(uuid, name);

		this.uuid = uuid;
		this.name = name.trim();
		this.symbolUrl = (symbolUrl != null && !symbolUrl.isBlank()) ? symbolUrl.trim() : null;
		this.description = (description != null && !description.isBlank()) ? description.trim() : null;
		this.createdAt = Instant.now();
		this.updatedAt = this.createdAt;
	}

	public void update(UUID uuid, String name, String symbolUrl, String description) {
		validateAllergen(uuid, name);

		this.name = name.trim();
		this.symbolUrl = (symbolUrl != null && !symbolUrl.isBlank()) ? symbolUrl.trim() : null;
		this.description = (description != null && !description.isBlank()) ? description.trim() : null;
		this.updatedAt = Instant.now();
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public String getSymbolUrl() {
		return symbolUrl;
	}

	public String getDescription() {
		return description;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	private void validateAllergen(UUID uuid, String name) {
		if (uuid == null)
			throw new IllegalArgumentException("Allergen UUID cannot be null");
		if (name == null || name.isBlank())
			throw new IllegalArgumentException("Allergen name cannot be null or empty");
	}

}
