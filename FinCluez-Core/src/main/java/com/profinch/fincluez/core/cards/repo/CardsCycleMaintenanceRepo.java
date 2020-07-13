package com.profinch.fincluez.core.cards.repo;

import com.profinch.fincluez.entities.cards.CardsCycleMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface CardsCycleMaintenanceRepo extends JpaRepository<CardsCycleMaintenance, BigDecimal> {
}
