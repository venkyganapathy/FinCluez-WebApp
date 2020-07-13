package com.profinch.fincluez.web.utils;

import com.profinch.fincluez.entities.responseModel.ResponseCode;
import com.profinch.fincluez.entities.messageCodes.SuccessCodes;
import com.profinch.fincluez.entities.responseModel.FinCluezResponse;
import com.profinch.fincluez.entities.model.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FinCluezResponseUtility {

    public static final Logger log = LoggerFactory.getLogger(FinCluezResponseUtility.class);

    public FinCluezResponse createSuccessResponseWithEntities(List<? extends Object> entityList, List<String> successCodeList){
        FinCluezResponse finCluezResponse = new FinCluezResponse();
        List<MessageModel> messageModelList = new ArrayList<>();

        finCluezResponse.setEntity(entityList);
        finCluezResponse.setResponseCode(ResponseCode.SUCCESS);

        for (String messageCode:successCodeList){
            MessageModel messageModel = new MessageModel();
            messageModel.setMessageCode(messageCode);
            messageModel.setMessage(getSuccessMessage(messageCode));
            messageModelList.add(messageModel);
        }

        finCluezResponse.setMessageModelList(messageModelList);
        return finCluezResponse;
    }

    public FinCluezResponse createSimpleSuccessResponse(){
        FinCluezResponse finCluezResponse = new FinCluezResponse();
        List<MessageModel> messageModelList = new ArrayList<>();
        finCluezResponse.setResponseCode(ResponseCode.SUCCESS);
        MessageModel messageModel = new MessageModel();
        messageModel.setMessageCode(SuccessCodes.S_SIMPLE_SUCCESS);
        messageModel.setMessage(getSuccessMessage(SuccessCodes.S_SIMPLE_SUCCESS));
        messageModelList.add(messageModel);
        finCluezResponse.setMessageModelList(messageModelList);
        return finCluezResponse;
    }

    public FinCluezResponse createErrorResponse(List<String> errorCodeList){
        FinCluezResponse finCluezResponse = new FinCluezResponse();
        List<MessageModel> messageModelList = new ArrayList<>();

        for (String messageCode:errorCodeList){
            MessageModel messageModel = new MessageModel();
            messageModel.setMessageCode(messageCode);
            messageModel.setMessage(getErrorMessage(messageCode));
            messageModelList.add(messageModel);
        }

        finCluezResponse.setMessageModelList(messageModelList);
        return finCluezResponse;

    }


    private String getSuccessMessage(String messageCode){
        return "success message";
    }

    private String getErrorMessage(String messageCode){
        return "error message";
    }
}
