package com.simple.com.loose.coupling;

public class Database1 implements DataProvider {
    private Data data;

    public Database1(Data data) {
        this.data = data;
        data.setId(1L);
        data.setMessage("Database1");
    }

    @Override
    public void showDetails() {
        System.out.println("Details : " + data.toString());
    }
}
