package giselletech.apiguestlist.service;

import giselletech.apiguestlist.dto.GuestRequestDTO;
import giselletech.apiguestlist.dto.GuestResponseDTO;
import giselletech.apiguestlist.entity.Guest;
import giselletech.apiguestlist.myutils.MyUtils;
import giselletech.apiguestlist.repository.GuestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@Slf4j
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

        try {
            guest.setId(MyUtils.generateRandomId());
            String normalizedName = Normalizer.normalize(guest.getName(), Normalizer.Form.NFD);
            Pattern padrao = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            String nameModified = padrao.matcher(normalizedName).replaceAll("");
            guest.setName(nameModified.toUpperCase());

            return ResponseEntity.status(HttpStatus.CREATED).body(guestRepository.save(guest));
        } catch (Exception e){
            log.error("Ocorreu um erro.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
        }
    }

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

    public ResponseEntity deleteAll() {
        guestRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("Convidados deletados");
    }
}






