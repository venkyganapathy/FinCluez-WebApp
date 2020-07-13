package com.profinch.fincluez.core.cards.repo;

import com.profinch.fincluez.entities.cards.CardsCollectionTarget;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CardsCollectionTargetRepo extends PagingAndSortingRepository<CardsCollectionTarget, BigDecimal> {
    public List<CardsCollectionTarget> findAllByEntityCode(String entityCode, Pageable pageable);

}
