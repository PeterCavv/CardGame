package cardgame.tripletriad.service;

import cardgame.tripletriad.entity.Element;
import cardgame.tripletriad.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElementService {

    @Autowired
    private ElementRepository elementRepository;

    public List<Element> findAllElements(){
        return elementRepository.findAll();
    }

    public Optional<Element> findById(String id){
        return elementRepository.findById(id);
    }
}
