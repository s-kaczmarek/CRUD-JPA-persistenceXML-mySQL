package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.math.BigInteger;

// https://www.youtube.com/watch?v=IoAwn3GYTME
// Ta klasa jest przykładam na to, jakiego typu obiekty możemy umieścić w bazie danych.
// Nie musimy tworzyć obiektu tej klasy, żeby tabala została utworzona - hibernate utworzy ją, ponieważ mamy nad
// klasą adnotację @Entity

@Entity
public class PossibleTypes {
    @Id
    private long id;

    // Możemy wrzucać do bazy typy prymitywne:
    private int someInt;
    private short someShort;
    private float spmeFloat;
    private double someDouble;
    private boolean someBoolean;

    // Możemy wrzucać do bazy typy obiektowe:
    private Integer someInteger;
    private BigDecimal someBigDecimal;
    private BigInteger someBigInteger;

    // Możemy wrzucać do bazy tablice:
    private int[] integerArray;
    private double[] doubleArray;

    // Możemy wrzucać do bazy enumy:
    private MyEnum myEnum;

    // Adnotacja "@Transient" oznacza, że to pole będzie ignorowane przy zapisie do bazy danych.
    @Transient
    private int ignoredField;


    // Obowiązkowe gettery i settery:

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }

    public short getSomeShort() {
        return someShort;
    }

    public void setSomeShort(short someShort) {
        this.someShort = someShort;
    }

    public float getSpmeFloat() {
        return spmeFloat;
    }

    public void setSpmeFloat(float spmeFloat) {
        this.spmeFloat = spmeFloat;
    }

    public double getSomeDouble() {
        return someDouble;
    }

    public void setSomeDouble(double someDouble) {
        this.someDouble = someDouble;
    }

    public boolean isSomeBoolean() {
        return someBoolean;
    }

    public void setSomeBoolean(boolean someBoolean) {
        this.someBoolean = someBoolean;
    }

    public Integer getSomeInteger() {
        return someInteger;
    }

    public void setSomeInteger(Integer someInteger) {
        this.someInteger = someInteger;
    }

    public BigDecimal getSomeBigDecimal() {
        return someBigDecimal;
    }

    public void setSomeBigDecimal(BigDecimal someBigDecimal) {
        this.someBigDecimal = someBigDecimal;
    }

    public BigInteger getSomeBigInteger() {
        return someBigInteger;
    }

    public void setSomeBigInteger(BigInteger someBigInteger) {
        this.someBigInteger = someBigInteger;
    }

    public int[] getIntegerArray() {
        return integerArray;
    }

    public void setIntegerArray(int[] integerArray) {
        this.integerArray = integerArray;
    }

    public double[] getDoubleArray() {
        return doubleArray;
    }

    public void setDoubleArray(double[] doubleArray) {
        this.doubleArray = doubleArray;
    }

    public MyEnum getMyEnum() {
        return myEnum;
    }

    public void setMyEnum(MyEnum myEnum) {
        this.myEnum = myEnum;
    }

    public int getIgnoredField() {
        return ignoredField;
    }

    public void setIgnoredField(int ignoredField) {
        this.ignoredField = ignoredField;
    }
}
