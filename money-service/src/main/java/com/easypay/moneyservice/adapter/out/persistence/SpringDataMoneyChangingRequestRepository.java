package com.easypay.moneyservice.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMoneyChangingRequestRepository extends JpaRepository<MoneyChangingRequestJpaEntity, Long> {
}