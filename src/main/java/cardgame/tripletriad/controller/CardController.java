package cardgame.tripletriad.controller;

import cardgame.tripletriad.entity.Card;
import cardgame.tripletriad.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cards", produces = MediaType.APPLICATION_JSON_VALUE)
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards(){
        return new ResponseEntity<List<Card>>(cardService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getOneCard(@PathVariable String id){
        Optional<Card> card = cardService.findById(id);

        if(card.isPresent()){
            return ResponseEntity.ok(card.get());
        }

        return ResponseEntity.notFound().build();
    }

}
