package io.github.sb66.repository;

import io.github.sb66.model.Trade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TradeRepository extends CrudRepository<Trade, Long> {

}
