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
public class GuestController {

    @Autowired
    private GuestService guestService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/")
    public List<GuestResponseDTO> getAll(){
        return guestService.getAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public Optional<Guest> getOne(@PathVariable Long id){
        return guestService.getOne(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/")
    public ResponseEntity add(@RequestBody GuestRequestDTO guestRequestDTO){
        return guestService.add(guestRequestDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody GuestRequestDTO guest) {
        return guestService.update(id, guest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return guestService.deleteById(id);
    }

}
