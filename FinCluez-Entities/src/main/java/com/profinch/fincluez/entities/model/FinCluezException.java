package com.profinch.fincluez.entities.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Getter
@Setter
public class FinCluezException extends Exception {
    private static final long serialVersionUID = -3967924560045591185L;
    private String errorCode;
    private String language;

    public FinCluezException(String errorCode, String language) {
        this.errorCode = errorCode;
        this.language = language;
    }

    public FinCluezException(String errorCode, String language, String message) {
        super(message);
        this.errorCode = errorCode;
        this.language = language;
    }

    public FinCluezException(String errorCode, String language, Exception exception) {
        super(exception);
        this.errorCode = errorCode;
        this.language = language;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
