package pl.piomin.services.dto;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class DepartmentDTO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
