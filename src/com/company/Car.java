package com.company;

public class Car extends Item {
    String carBrand;
    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Car(String name, String brand){
        super(ItemClass.CAR);
        this.carBrand=brand;
    }

    public static boolean createCar(String carBrand,String registrationNumber){
        String myString = "INSERT INTO Cars(carBrand,registrationNumber,itemClassID) Values ('"+carBrand+"','"+registrationNumber+"',2);";
        if(MySqlCon.myExecuteQuery(myString)){
            return true;
        }else{
            return false;
        }
    }

}
