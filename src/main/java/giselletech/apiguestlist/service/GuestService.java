package giselletech.apiguestlist.service;

import giselletech.apiguestlist.dto.GuestRequestDTO;
import giselletech.apiguestlist.dto.GuestResponseDTO;
import giselletech.apiguestlist.entity.Guest;
import giselletech.apiguestlist.myutils.MyUtils;
import giselletech.apiguestlist.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

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

    public Optional<Guest> getOne(Long id){
        Optional<Guest> guest = guestRepository.findById(id);
        return guest;
    }

    public ResponseEntity add(GuestRequestDTO guestRequestDTO){
        Guest guest = new Guest(guestRequestDTO);

        guest.setId(MyUtils.generateRandomId());
        String normalizedName = Normalizer.normalize(guest.getName(), Normalizer.Form.NFD);
        Pattern padrao = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String nameModified = padrao.matcher(normalizedName).replaceAll("");
        guest.setName(nameModified.toUpperCase());

        return ResponseEntity.status(HttpStatus.CREATED).body(guestRepository.save(guest));
    }

//    public Guest update(Guest guest) {
//        Guest guestToUpdate = guestRepository.findById(guest.getId()).get();
//        guestToUpdate.setName(guest.getName().toUpperCase());
//        return guestRepository.save(guestToUpdate);
//    }

        public ResponseEntity update(Long id, GuestRequestDTO guestRequestDTO) {
        Optional<Guest> guestOptional = guestRepository.findById(id);

        if(guestOptional.isPresent()){
            Guest guestToUpdate = guestOptional.get();
            guestToUpdate.setName(guestRequestDTO.name().toUpperCase());
            return ResponseEntity.status(HttpStatus.OK).body(guestRepository.save(guestToUpdate));
        }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Convidado não existe.");
    }

    public ResponseEntity deleteById(Long id) {
        guestRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Convidado ID= " +
                id + " deletado.");
    }
}
