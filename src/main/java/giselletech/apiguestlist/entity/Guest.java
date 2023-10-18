package giselletech.apiguestlist.entity;

import giselletech.apiguestlist.controller.dto.GuestRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "guests")
@Entity(name = "guests")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Guest {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Guest(GuestRequestDTO guestRequestDTO){
        this.name = guestRequestDTO.name();
    }

}
