package com.Pasionproject.PasionProject.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorDetails {



        private String title;
        private int status;
        private String details;
        private String timeStamp;
        private String developerMessage;
        private Map<String, List<ValidationError>> errors = new HashMap<>();


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

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getDeveloperMessage() {
            return developerMessage;
        }

        public void setDeveloperMessage(String developerMessage) {
            this.developerMessage = developerMessage;
        }

        public Map<String, List<ValidationError>> getErrors() {
            return errors;
        }

        public void setErrors(Map<String, List<ValidationError>> errors) {
            this.errors = errors;
        }
    }


