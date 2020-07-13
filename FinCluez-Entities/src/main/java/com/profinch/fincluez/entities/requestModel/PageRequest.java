package com.profinch.fincluez.entities.requestModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRequest {
    private Integer currentPageNumber;
    private Integer pageSize;
    private Boolean sortingRequired;
    private String sortByAttribute;
}
