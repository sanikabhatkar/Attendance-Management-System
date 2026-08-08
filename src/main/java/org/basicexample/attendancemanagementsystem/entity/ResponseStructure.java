package org.basicexample.attendancemanagementsystem.entity;

public class ResponseStructure<T> {

    private String message;
    private int status;
    private T data;

    public ResponseStructure(String message, int status, T data) {
        super();
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public ResponseStructure() {
        super();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
