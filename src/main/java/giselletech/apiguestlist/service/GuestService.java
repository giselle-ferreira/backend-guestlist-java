package giselletech.apiguestlist.service;

import com.sun.jdi.LongValue;
import giselletech.apiguestlist.dto.GuestRequestDTO;
import giselletech.apiguestlist.dto.GuestResponseDTO;
import giselletech.apiguestlist.entity.Guest;
import giselletech.apiguestlist.myutils.MyUtils;
import giselletech.apiguestlist.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<GuestResponseDTO> getAll(){

        return guestRepository
                .findAll()
                .stream()
                .map(GuestResponseDTO::new)
                .toList();
    }

    public void add(@RequestBody GuestRequestDTO guestRequestDTO){
        Guest guest = new Guest(guestRequestDTO);
        guest.setId(MyUtils.generateRandomId());
        guestRepository.save(guest);
    }

    public void deleteById(Long id) {
        guestRepository.deleteById(id);
    }
}
