package com.maciejak.futurum_task.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CampaignDTO {

    private Long id;

    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name is required")
    private String name;

    @NotNull(message = "Min Amount is required")
    private Double minAmount;

    @NotNull(message = "Status is required")
    private Boolean status;

    @NotNull(message = "Radius is required")
    private Double radius;

    @NotNull(message = "Fund is required")
    private Double fund;

    @NotEmpty(message = "Key words list should contains at least one element")
    private List<KeyWordDTO> keyWords;

    private TownDTO town;

    public CampaignDTO() {
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

    public Double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public TownDTO getTown() {
        return town;
    }

    public void setTown(TownDTO town) {
        this.town = town;
    }

    public Double getFund() {
        return fund;
    }

    public void setFund(Double fund) {
        this.fund = fund;
    }

    public List<KeyWordDTO> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(List<KeyWordDTO> keyWords) {
        this.keyWords = keyWords;
    }

    @Override
    public String toString() {
        return "CampaignDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minAmount=" + minAmount +
                ", status=" + status +
                ", radius=" + radius +
                ", town=" + town +
                '}';
    }
}
