package com.example.RestaurantCode.Restaurant.Response;

import lombok.Data;


public class ResponseModel <T>{
    private String message;
    private boolean success;
    private T data;

    public ResponseModel(String message, boolean success){
        this.message = message;
        this.success = success;
    }

    public ResponseModel(String message, boolean success, T data){
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public String getMessage(){ return message;}
    public boolean getSuccess(){ return success;}
    public T getData(){ return data;}

    public boolean isSuccess() {
        return success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
