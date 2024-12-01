package com.simple.com.loose.coupling;

public class Database2 implements DataProvider {
    private Data data;

    public Database2(Data data) {
        this.data = data;
        data.setId(2L);
        data.setMessage("Database2");
    }

    @Override
    public void showDetails() {
        System.out.println("Details : " + data.toString());
    }
}
