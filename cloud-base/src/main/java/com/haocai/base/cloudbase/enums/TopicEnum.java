package com.haocai.base.cloudbase.enums;

public enum TopicEnum {

    SKT("topic_second_kill");

    private String value;

    TopicEnum(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }

    public String getValue() {
        return this.value;
    }
}
