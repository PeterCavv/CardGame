package cardgame.tripletriad.controller;

import cardgame.tripletriad.entity.Element;
import cardgame.tripletriad.service.ElementService;
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
@RequestMapping( value = "/elements", produces = MediaType.APPLICATION_JSON_VALUE)
public class ElementController {

    @Autowired
    private ElementService elementService;

    @GetMapping
    public ResponseEntity<List<Element>> getElements(){
        return new ResponseEntity<>(elementService.findAllElements(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Element> getOneElement(@PathVariable String id){
        Optional<Element> element = elementService.findById(id);

        if(element.isPresent()){
            return ResponseEntity.ok(element.get());
        }

        return ResponseEntity.notFound().build();
    }
}
