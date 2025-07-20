package com.tablease.menu.app.gateway;

import java.util.List;
import java.util.UUID;

import com.tablease.menu.domain.Allergen;

public interface IAllergenGateway {
		List<Allergen> findAllByAllergenByUuidIn(List<UUID> allergenIds);

}
