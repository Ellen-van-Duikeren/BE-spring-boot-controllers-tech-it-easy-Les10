package nl.novi.TechItEasy.Controllers;

import nl.novi.TechItEasy.Exceptions.IndexOutOfBoundsException;
import nl.novi.TechItEasy.Exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionsController {

    // ik had hier eerst private final List<String> televisionDataBase = Arrays.asList("Philips 43PUS6504/12", "Nikkei NH3216SMART", "Samsung QE55Q60T", "Hitachi 43HAK6152", "Philips 55PUS7805", "Brandt B2450HD"); staan, maar dat werkte niet in de post en delete methode omdat ie er kennelijk dan geen array van maakt maar een list waarop ik de add en remove methode niet mocht uitvoeren.
    private static final ArrayList<String> televisionDataBase = new ArrayList<>();

    // volgens feedback is het netter om deze add functies nit in de constructor te zetten
    static
    {
        televisionDataBase.add("Philips 43PUS6504");
        televisionDataBase.add("Nikkei NH3216SMART");
        televisionDataBase.add("Samsung QE55Q60T");
        televisionDataBase.add("Hitachi 43HAK6152");
        televisionDataBase.add("Philips 55PUS7805");
        televisionDataBase.add("Brandt B2450HD");
    }

    public TelevisionsController() {

    }

    @GetMapping("")
    public ResponseEntity<Object> getAllTelevisions() {
        return new ResponseEntity(televisionDataBase, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTelevision(@PathVariable int id) {
        if (id >= 0 && id < televisionDataBase.size()) {
            return ResponseEntity.ok(televisionDataBase.get(id));
        } else {
            throw new IndexOutOfBoundsException("invalid id");
        }
    }

    @PostMapping("")
    public  ResponseEntity<Object> addTelevision(@RequestBody String tv) {
        televisionDataBase.add(tv);
        return new ResponseEntity<>(tv + " is added.", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody String tv) {
        if (id >= 0 && id < televisionDataBase.size()) {
            televisionDataBase.set(id, tv);
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>("invalid id", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable int id) {
        if (id >= 0 && id < televisionDataBase.size()) {
            televisionDataBase.remove(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new IndexOutOfBoundsException("invalid id");
        }
    }

}
