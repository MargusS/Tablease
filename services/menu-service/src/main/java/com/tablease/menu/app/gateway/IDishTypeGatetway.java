package com.tablease.menu.app.gateway;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.tablease.menu.domain.DishType;

public interface IDishTypeGatetway {
	Optional<DishType> findByUuid(UUID dishTypeId);
	List<DishType> findAll();
}
