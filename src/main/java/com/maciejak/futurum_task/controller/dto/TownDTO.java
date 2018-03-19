package com.maciejak.futurum_task.controller.dto;

public class TownDTO {

    private Long id;
    private String name;

    public TownDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TownDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}