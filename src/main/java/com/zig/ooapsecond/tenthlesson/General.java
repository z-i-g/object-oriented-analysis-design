package com.zig.ooapsecond.tenthlesson;

import java.io.*;
import java.util.Objects;

public class General extends Object implements Cloneable, Serializable {
    private String name;

    // для запрета переопределения в потомках помечаем в родителе как final
    public final void copy(General targetObject) {
        targetObject.name = this.name;
    }

    @Override
    public General clone() {
        General cloneGeneral = new General();
        copy(cloneGeneral);
        return cloneGeneral;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        General general = (General) o;
        return Objects.equals(name, general.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public byte[] serialize() {
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(byteOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.flush();
            return byteOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Object deserialize(byte[] bytePresent) {
        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytePresent);
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(byteInputStream);
            return objectInputStream.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "General { name = " + name + "}";
    }

    public boolean isInstance(Class<?> classType) {
        return this.getClass().isInstance(classType);
    }

    public Class<?> getType() {
        return this.getClass();
    }
}