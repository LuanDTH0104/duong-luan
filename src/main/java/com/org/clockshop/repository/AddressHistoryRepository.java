package com.org.clockshop.repository;

import com.org.clockshop.model.AddressHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressHistoryRepository extends JpaRepository<AddressHistory,Integer> {
}
