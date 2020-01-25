package org.wwpmo.wsims.models;

public class ResponseObject {

    private  int statusCode;
    private  String status;

    public ResponseObject(int statusCode, String status) {
        this.statusCode = statusCode;
        this.status = status;
    }

    public ResponseObject() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReponseObject{" +
                "statusCode=" + statusCode +
                ", status='" + status + '\'' +
                '}';
    }
}
