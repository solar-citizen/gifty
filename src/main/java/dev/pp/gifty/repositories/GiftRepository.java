package dev.pp.gifty.repositories;

import dev.pp.gifty.entities.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiftRepository extends JpaRepository<Gift, Long> {

    @Procedure(name = "find_best_fit_gifts")
    List<Object[]> findBestFitGifts(Number[] selectedCategories, int numGifts);

}
