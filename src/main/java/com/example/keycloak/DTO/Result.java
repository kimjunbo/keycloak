package com.example.keycloak.DTO;

public class Result {
    public String code;
    public String message;
    public Object data;
    public boolean isSuccess;

    public Result(boolean status,Object response){
        this.isSuccess = status;
        if(status){
           this.code = "SUCCESS";
           this.message="요청에 성공하였습니다.";
           this.data= response;
        }
        else{
            this.code = "FAIL";
            this.message= (String) response;
            this.data= null;
        }
    }
}
