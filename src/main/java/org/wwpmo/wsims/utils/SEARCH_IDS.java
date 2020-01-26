package org.wwpmo.wsims.utils;

public enum SEARCH_IDS {

    CUSTOMERGROUP(1),
    CUSTOMER(2);

    private int value;

    private SEARCH_IDS(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
