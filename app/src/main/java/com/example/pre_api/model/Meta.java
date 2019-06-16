package com.example.pre_api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {
    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("message")
    @Expose
    private String message;

    public Meta(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
