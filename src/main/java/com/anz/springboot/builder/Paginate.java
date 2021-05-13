package com.anz.springboot.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Paginate {

    /**
     * number of page number
     */
    private int page;

    private int totalPages;

    /**
     * total element
     */
    private int totalElements;

    private int size;

}
