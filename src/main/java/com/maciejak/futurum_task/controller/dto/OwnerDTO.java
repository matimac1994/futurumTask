package com.maciejak.futurum_task.controller.dto;

public class OwnerDTO {
    private Long id;
    private Double emeraldAccount;

    public OwnerDTO() {
    }

    public OwnerDTO(Long id, Double emeraldAccount) {
        this.id = id;
        this.emeraldAccount = emeraldAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getEmeraldAccount() {
        return emeraldAccount;
    }

    public void setEmeraldAccount(Double emeraldAccount) {
        this.emeraldAccount = emeraldAccount;
    }
}
