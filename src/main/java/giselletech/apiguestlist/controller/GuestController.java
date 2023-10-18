package giselletech.apiguestlist.controller;

import giselletech.apiguestlist.dto.GuestRequestDTO;
import giselletech.apiguestlist.dto.GuestResponseDTO;
import giselletech.apiguestlist.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/")
    public void add(@RequestBody GuestRequestDTO guestRequestDTO){
        guestService.add(guestRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        guestService.deleteById(id);
    }

}
