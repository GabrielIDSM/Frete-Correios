package br.com.gabrielidsm.correios.Error;

public class ResourceNotFoundDetails {
    //Atributos
    private String title;
    private int status;
    private String detail;
    private long timestamp;
    private String developerMessage;

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }
    
    //Builder

    public static class Builder {

        private String title;
        private int status;
        private String detail;
        private long timestamp;
        private String developerMessage;

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

        public ResourceNotFoundDetails build() {
            return new br.com.gabrielidsm.correios.Error.ResourceNotFoundDetails(title, status, detail, timestamp, developerMessage);
        }
    }

    public static ResourceNotFoundDetails.Builder builder() {
        return new ResourceNotFoundDetails.Builder();
    }

    private ResourceNotFoundDetails(final String title, final int status, final String detail, final long timestamp, final String developerMessage) {
        this.title = title;
        this.status = status;
        this.detail = detail;
        this.timestamp = timestamp;
        this.developerMessage = developerMessage;
    }
    
}
