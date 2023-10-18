package giselletech.apiguestlist.controller;

import giselletech.apiguestlist.controller.dto.GuestRequestDTO;
import giselletech.apiguestlist.controller.dto.GuestResponseDTO;
import giselletech.apiguestlist.entity.Guest;
import giselletech.apiguestlist.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

    @GetMapping("/")
    public List<GuestResponseDTO> getAll(){

        return guestRepository
                .findAll()
                .stream()
                .map(GuestResponseDTO::new)
                .toList();
    }

    @PostMapping("/")
    public void add(@RequestBody GuestRequestDTO guestRequestDTO){
        Guest guest = new Guest(guestRequestDTO);
        guestRepository.save(guest);
    }

}
