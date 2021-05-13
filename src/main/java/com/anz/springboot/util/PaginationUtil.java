package com.anz.springboot.util;

import com.anz.springboot.dto.PageRequestDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PaginationUtil {
    public static Pageable getPageable(PageRequestDTO requestDTO) {
        return null == requestDTO.getSortBy() ? PageRequest.of(requestDTO.getPage(), requestDTO.getLimit())
                : PageRequest.of(requestDTO.getPage(), requestDTO.getLimit(), constructSort(requestDTO.getSortBy(), requestDTO.getDirection()));
    }

    private static Sort constructSort(String sortBy, String direction) {
        if (null != direction && direction.equalsIgnoreCase("asc")) {
            Sort.Order order = Sort.Order.asc(sortBy);
            return Sort.by(order);
        } else {
            Sort.Order order = Sort.Order.desc(sortBy);
            return Sort.by(order);
        }
    }

}
