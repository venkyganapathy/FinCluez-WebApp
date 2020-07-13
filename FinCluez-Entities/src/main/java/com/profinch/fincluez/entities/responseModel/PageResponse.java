package com.profinch.fincluez.entities.responseModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageResponse {
    private Long currentPageNumber;
    private Long pageSize;
    private Boolean sortingRequired;
    private String sortByAttribute;
    private Long totalPages;
    private Long totalRecords;
}
