package com.yang.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Package:com.yixin.ndss.controller.util
 *
 * @author YixinCapital -- Yang.Liu
 *         2018/1/25 14:16
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvokeResult<T extends Object> {
    private Object data;
    private String errorMessage;
    private boolean hasErrors;

    public InvokeResult() {
        super();
    }

    public InvokeResult(T dto) {
        super();
        this.data = dto;
    }

    public InvokeResult(List<T> dtos) {
        super();
        this.data = dtos;
    }

    public InvokeResult(Page<T> page) {
        super();
        this.data = page;
    }

    public void setData(T dto) {
        this.data = dto;
    }

    public InvokeResult<T> success() {
        this.hasErrors = false;
        return this;
    }

    public InvokeResult<T> failure(String message) {
        this.hasErrors = true;
        this.errorMessage = message;
        return this;
    }

    public Object getData() {
        return this.data;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public boolean isHasErrors() {
        return this.hasErrors;
    }

    public boolean isSuccess() {
        return !this.hasErrors;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

}
