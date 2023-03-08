package dev.pp.gifty.services;

import dev.pp.gifty.entities.Gift;
import dev.pp.gifty.repositories.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftService {

    @Autowired
    private GiftRepository giftRepository;

    public List<Gift> allGifts() {
        return giftRepository.findAll();
    }

}
