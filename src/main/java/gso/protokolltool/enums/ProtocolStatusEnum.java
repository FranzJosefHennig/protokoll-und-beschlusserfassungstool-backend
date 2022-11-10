package gso.protokolltool.enums;

public enum ProtocolStatusEnum {
    OPEN(0),
    DONE(1);

    private int value;

    ProtocolStatusEnum(int value) {
        this.value  = value;
    }

    public int getValue() {
        return value;
    }
}
