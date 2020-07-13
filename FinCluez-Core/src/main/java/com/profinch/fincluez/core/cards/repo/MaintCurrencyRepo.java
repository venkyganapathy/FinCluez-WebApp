package com.profinch.fincluez.core.cards.repo;

import com.profinch.fincluez.entities.cards.MaintCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

import java.math.BigDecimal;

public interface MaintCurrencyRepo extends JpaRepository<MaintCurrency, BigDecimal> {
}
