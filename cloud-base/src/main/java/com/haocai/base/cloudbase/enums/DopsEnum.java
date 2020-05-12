package com.haocai.base.cloudbase.enums;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/5/12 17:19
 **/
public enum DopsEnum {

    DOPS10("DOPS1.0", "海豚1.0"),
    DOPS22("DOPS2.2", "海豚2.2"),
    DOPS23("DOPS2.3", "海豚2.3"),
    DOPS24("DOPS2.4", "海豚2.4");

    private String value;

    private String label;

    private DopsEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
}
