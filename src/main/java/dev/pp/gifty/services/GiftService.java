package dev.pp.gifty.services;

import dev.pp.gifty.entities.Gift;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GiftService {

    Optional<List<Gift>> getAllGifts();

    Optional<Gift> getGiftById(Long id);

    Optional<Gift> createGift(Gift gift);

    Optional<Gift> updateGift(Gift gift);

    void deleteGift(Long id);

    List<Gift> getBestFitGifts(String[] selectedCategories, Integer numGifts);

}
