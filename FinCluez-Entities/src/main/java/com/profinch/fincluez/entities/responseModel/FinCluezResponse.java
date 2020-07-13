package com.profinch.fincluez.entities.responseModel;

import com.profinch.fincluez.entities.model.MessageModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FinCluezResponse {
    private Object entity;
    private List<Object> entityList;
    private PageResponse pageResponse;
    private ResponseCode responseCode;
    private List<MessageModel> messageModelList;

}
