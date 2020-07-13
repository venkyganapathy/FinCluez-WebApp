package com.profinch.fincluez.core.cards.repo;

import com.profinch.fincluez.entities.cards.CardsCollectorAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface CardsCollectorAssignmentRepo extends JpaRepository<CardsCollectorAssignment, BigDecimal> {
}
