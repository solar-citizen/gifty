package dev.pp.gifty.repositories;

import dev.pp.gifty.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftRepository extends JpaRepository<Gift, Integer> {
}
