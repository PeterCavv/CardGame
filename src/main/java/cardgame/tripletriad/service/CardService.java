package cardgame.tripletriad.service;

import cardgame.tripletriad.entity.Card;
import cardgame.tripletriad.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public List<Card> findAll(){
        return cardRepository.findAll();
    }

    public Optional<Card> findById(String id){
        return cardRepository.findById(id);
    }
}
