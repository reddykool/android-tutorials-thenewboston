package com.example.reddyz.basicsqlite;

/**
 * Created by Reddyz on 29-09-2016.
 */
public class Products {
    private int _id;
    private String _name;

    public Products() {
    }

    public Products(String name) {
        this._name = name;
    }

    public void set_id(int id) {
        this._id = id;
    }

    public void set_name(String name) {
        this._name = name;
    }

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }
}
