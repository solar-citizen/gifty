package dev.pp.gifty.controllers;

import dev.pp.gifty.entities.Category;
import dev.pp.gifty.entities.Gift;
import dev.pp.gifty.services.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gifts")
public class GiftController {

    @Autowired
    private GiftService giftService;

    @GetMapping("/all")
    public ResponseEntity<Optional<List<Gift>>> getAllGifts() {
        return new ResponseEntity<>(giftService.getAllGifts(), HttpStatus.OK);
    }

    @GetMapping("/{gifId}")
    public ResponseEntity<Optional<Gift>> getGift(@PathVariable Long gifId) {
        return new ResponseEntity<>(giftService.getGiftById(gifId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Optional<Gift>> addGift(@RequestBody Gift gift) {
        return new ResponseEntity<>(giftService.createGift(gift), HttpStatus.CREATED);
    }

    @DeleteMapping("/{giftId}/remove")
    public ResponseEntity<Void> removeGift(@PathVariable Long giftId) {
        giftService.deleteGift(giftId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/edit")
    public ResponseEntity<Optional<Gift>> editGift(@RequestBody Gift gift) {
        return new ResponseEntity<>(giftService.updateGift(gift), HttpStatus.OK);
    }

    @GetMapping("/find-best-fit")
    public List<Gift> getBestFitGifts(@RequestParam String[] categories, @RequestParam int numGifts) {
        return giftService.getBestFitGifts(categories, numGifts);
    }

}
