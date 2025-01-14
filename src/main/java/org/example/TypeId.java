package org.example;
enum Types {
    TYPE,
    LOCAL_VAR,
    CALL,
    THIS
}


record TypeId(Types t, String name) {
    public TypeId(Types t) {
        this(t, null);
    }
}
