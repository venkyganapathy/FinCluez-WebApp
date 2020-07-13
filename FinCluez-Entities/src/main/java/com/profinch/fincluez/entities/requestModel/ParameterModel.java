package com.profinch.fincluez.entities.requestModel;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;

@Getter
@Setter
public class ParameterModel {
    private HashMap<String, String> stringParameters;
    private HashMap<String, Long> longParameters;
    private HashMap<String, Date> dateParameters;
    private HashMap<String, Boolean> booleanParameters;
}
