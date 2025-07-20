package com.tablease.menu.app.gateway;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.tablease.menu.domain.Dish;

public interface IDishGateway {
	Dish save(Dish dish);

	Optional<Dish> findByUuid(UUID dishId);

	List<Dish> findAll();

	Dish deleteByUuid(UUID dishUuid);
}
