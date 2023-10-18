package giselletech.apiguestlist.controller;

import giselletech.apiguestlist.controller.dto.GuestResponseDTO;
import giselletech.apiguestlist.entity.Guest;
import giselletech.apiguestlist.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

//    @GetMapping("/")
//    public List<GuestResponseDTO> getAll(){
//
//        List<GuestResponseDTO> guestList = guestRepository
//                .findAll()
//                .stream()
//                .map(GuestResponseDTO::new);
//        return guestList;
//    }

    @GetMapping("/")
    public List<Guest> getAll(){
        return guestRepository.findAll();
    }
}
