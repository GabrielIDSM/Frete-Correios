package br.com.gabrielidsm.correios.Error;

public class ValidationErrorDetails {
    //Atributos
    private String title;
    
    private int status;
    
    private String detail;
    
    private long timestamp;
    
    private String developerMessage;
    
    private String field;
    
    private String fieldMessages;
    //Getters e Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldMessages() {
        return fieldMessages;
    }

    public void setFieldMessages(String fieldMessages) {
        this.fieldMessages = fieldMessages;
    }
    //Builder
    public static class Builder {

        private String title;
        private int status;
        private String detail;
        private long timestamp;
        private String developerMessage;
        private String field;
        private String fieldMessages;

        private Builder() {
        }

        public Builder title(final String value) {
            this.title = value;
            return this;
        }

        public Builder status(final int value) {
            this.status = value;
            return this;
        }

        public Builder detail(final String value) {
            this.detail = value;
            return this;
        }

        public Builder timestamp(final long value) {
            this.timestamp = value;
            return this;
        }

        public Builder developerMessage(final String value) {
            this.developerMessage = value;
            return this;
        }

        public Builder field(final String value) {
            this.field = value;
            return this;
        }

        public Builder fieldMessages(final String value) {
            this.fieldMessages = value;
            return this;
        }

        public ValidationErrorDetails build() {
            return new br.com.gabrielidsm.correios.Error.ValidationErrorDetails(title, status, detail, timestamp, developerMessage, field, fieldMessages);
        }
    }

    public static ValidationErrorDetails.Builder builder() {
        return new ValidationErrorDetails.Builder();
    }

    private ValidationErrorDetails(final String title, final int status, final String detail, final long timestamp, final String developerMessage, final String field, final String fieldMessages) {
        this.title = title;
        this.status = status;
        this.detail = detail;
        this.timestamp = timestamp;
        this.developerMessage = developerMessage;
        this.field = field;
        this.fieldMessages = fieldMessages;
    }
    
}
