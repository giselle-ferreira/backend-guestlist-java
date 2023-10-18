package giselletech.apiguestlist.controller.dto;

import giselletech.apiguestlist.entity.Guest;

public record GuestResponseDTO(Long id, String name) {

    public GuestResponseDTO(Guest guest){
        this(guest.getId(), guest.getName());
    }
}
