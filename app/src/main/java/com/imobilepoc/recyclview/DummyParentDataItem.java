package com.imobilepoc.recyclview;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <b></b>
 * <p>This class is used to </p>
 * Created by Rohit.
 */
class DummyParentDataItem implements Serializable {
    private String sub,parentName;
    private int rec;
    private ArrayList<DummyChildDataItem> childDataItems;

    public DummyParentDataItem(String parentName, int rec,String sub,ArrayList<DummyChildDataItem> childDataItems) {
        this.parentName = parentName;
        this.childDataItems = childDataItems;
        this.sub=sub;
        this.rec=rec;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public ArrayList<DummyChildDataItem> getChildDataItems() {
        return childDataItems;
    }

    public void setChildDataItems(ArrayList<DummyChildDataItem> childDataItems) {
        this.childDataItems = childDataItems;
    }

    public String getSub() {
        return sub;
    }
    public void setSub(String sub) {
        this.sub = sub;
    }

    public int getRec() {
        return rec;
    }
    public void setRec(int rec) {
        this.rec = rec;
    }
}
