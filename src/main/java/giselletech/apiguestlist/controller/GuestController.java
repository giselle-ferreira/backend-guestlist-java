package giselletech.apiguestlist.controller;

import giselletech.apiguestlist.dto.GuestRequestDTO;
import giselletech.apiguestlist.dto.GuestResponseDTO;
import giselletech.apiguestlist.entity.Guest;
import giselletech.apiguestlist.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/guests")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GuestController {

    @Autowired
    private GuestService guestService;


    @GetMapping
    public List<GuestResponseDTO> getAll(){
        return guestService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Guest> getOne(@PathVariable Long id){
        return guestService.getOne(id);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody GuestRequestDTO guestRequestDTO){
        return guestService.add(guestRequestDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody GuestRequestDTO guest) {
        return guestService.update(id, guest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return guestService.deleteById(id);
    }

    @DeleteMapping
    public ResponseEntity deleteAllGuests(){
        return guestService.deleteAll();
    }

}
