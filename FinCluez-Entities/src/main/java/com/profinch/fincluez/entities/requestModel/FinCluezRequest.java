package com.profinch.fincluez.entities.requestModel;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FinCluezRequest {
    private String entityCode;
    private Object entity;
    private List<Object> entityList;
    private PageRequest pageRequest;
    private ParameterModel parameterModel;
    private String language;
}
