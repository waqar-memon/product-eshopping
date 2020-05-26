package com.systems.productscatalogservice.commons;

public class ResponseEntity<T> {
    private T data;
    private Message message;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public static <T> ResponseEntity<T> ok(T data, String message){
        ResponseEntity<T> responseEntity = new ResponseEntity<>();
        responseEntity.setData(data);
        responseEntity.setMessage(responseEntity.new Message(message, "SUCCESS", "200"));
        return responseEntity;
    }

    public class Message{
        private String message;
        private String code;
        private String status;

        public Message(){}

        public Message(String message, String code, String status) {
            this.message = message;
            this.code = code;
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
