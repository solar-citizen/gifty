package dev.pp.gifty.services;

import dev.pp.gifty.entities.Category;
import dev.pp.gifty.entities.Gift;
import dev.pp.gifty.repositories.GiftRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class GiftServiceImpl implements GiftService {

    private static final Logger log = LogManager.getLogger(GiftServiceImpl.class);

    @Autowired
    private GiftRepository giftRepository;

    @Transactional
    public Optional<List<Gift>> getAllGifts() {
        return Optional.of(giftRepository.findAll());
    }

    @Transactional
    public Optional<Gift> getGiftById(Long id) {
        return Optional.ofNullable(giftRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gift not found with id " + id)));
    }

    @Transactional
    public Optional<Gift> createGift(Gift gift) {
        try {
            giftRepository.save(gift);
            return Optional.of(gift);
        } catch (DataAccessException e) {
            log.error("Failed to create a new gift./n", e);
            return Optional.empty();
        }
    }

    @Transactional
    public void deleteGift(Long id) {
        Gift gift = giftRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gift not found with id " + id));
        giftRepository.delete(gift);
    }

    @Transactional
    public Optional<Gift> updateGift(Gift gift) {
        try {
            giftRepository.save(gift);
            return Optional.of(gift);
        } catch (DataAccessException e) {
            log.error("Failed to update a gift./n", e);
            return Optional.empty();
        }
    }

    public List<Gift> getBestFitGifts(String[] selectedCategories, Integer numGifts) {
        Number[] selectedCategoriesNumbers = Stream.of(selectedCategories)
                .map(Integer::valueOf)
                .toArray(Number[]::new);
        List<Object[]> result = giftRepository.findBestFitGifts(selectedCategoriesNumbers, numGifts);
        return result.parallelStream()
                .map(obj -> {
                    Long id = ((Number) obj[0]).longValue();
                    String name = (String) obj[1];
                    String description = (String) obj[2];
                    return new Gift(id, name, description);
                })
                .toList();
    }

//    public List<Gift> getBestFitGifts(Number[] selectedCategoriesIds, Integer numGifts) {
//        String[] selectedCategories = Stream.of(selectedCategoriesIds)
//                .map(id -> categoryRepository.findById(id.longValue()))
//                .filter(Optional::isPresent)
//                .map(Optional::get)
//                .map(Category::getName)
//                .toArray(String[]::new);

}
