package pl.piomin.services.dto;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class OrganizationDTO {

    private String name;
    private String address;

    public OrganizationDTO() {
    }

    public OrganizationDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
