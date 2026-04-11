package model;

import java.util.ArrayList;
import java.util.List;

// singleton
public class Sales {
    private List<Product> originalData = new ArrayList<>();
    private List<Product> updatedData = new ArrayList<>();
    private static Sales salesInstance;

    private Sales(){}

    public static Sales getSalesInstance(){
        if(salesInstance == null){
            salesInstance = new Sales();
        }
        return salesInstance;
    }


    private boolean doSetOgData = true;
    public void setOriginalData(List<Product> currentSales){
        this.originalData = currentSales;
        doSetOgData = false;
    }
    public List<Product> getOriginalData(){
        return originalData;
    }
    public boolean getDoSetOgData(){
        return doSetOgData;
    }

    public List<Product> getUpdatedData() {
        return updatedData;
    }
    public void setUpdatedData(List<Product> updatedData) {
        this.updatedData = updatedData;
    }
}
