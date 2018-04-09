package com.example.fondn.leadsversatile.adapterandencrypter;

public class StoreEncryp {
    private String name;

    public StoreEncryp(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StoreEncryp{" +
                "name='" + name + '\'' +
                '}';
    }
}
