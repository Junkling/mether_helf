package io.elice.shoppingmall.domain.bill.repository;

import io.elice.shoppingmall.domain.bill.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BillRepository extends JpaRepository<Bill, Long>{
}
