package com.ms.intro.resources;

import org.springframework.data.repository.CrudRepository;

public interface ResourcesRepo extends CrudRepository<ResourceDomain, Integer> {
}
