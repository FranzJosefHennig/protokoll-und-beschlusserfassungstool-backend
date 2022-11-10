package gso.protokolltool.enums;

public enum ConferenceTypeEnum {
    LEHRERKONFERENZ(0),
    ABTEILUNGSKONFERENZ(1);

    private int value;

    ConferenceTypeEnum(int value) {
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
}
