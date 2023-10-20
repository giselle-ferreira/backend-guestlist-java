package giselletech.apiguestlist.entity;

import giselletech.apiguestlist.dto.GuestRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "guests")
@Entity(name = "guests")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Guest {


    @Id
    private Long id;
    private String name;

    public Guest(GuestRequestDTO guestRequestDTO){
        this.name = guestRequestDTO.name();
    }

}
