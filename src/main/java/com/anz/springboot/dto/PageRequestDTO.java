package com.anz.springboot.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class PageRequestDTO {
    private Integer page;
    private Integer limit;
    private String sortBy;
    private String direction;

    public PageRequestDTO(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
    }

    public PageRequestDTO(Integer page, Integer limit, String sortBy, String direction) {
        this.page = page;
        this.limit = limit;
        this.sortBy = sortBy;
        this.direction = direction;
    }
}
