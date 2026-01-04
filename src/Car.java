public class Car extends Vehicle implements Servicable {
    private int numberOfDoors;
    public Car(String model,int year,double basePrice,int numberOfDoors){
        super(model,year,basePrice);
        this.numberOfDoors=numberOfDoors;
    }
    public int getNumberOfDoors(){
        return numberOfDoors;
    }
    public void setNumberOfDoors(int numberOfDoors){
        if(numberOfDoors<=0){
            throw new IllegalArgumentException("doors must be >0 ");
        }
        this.numberOfDoors=numberOfDoors;
    }
    @Override
    public double calculateInsuranceFee(){
        int age = getage(java.time.Year.now().getValue());
        return basePrice*0.07+age*50;
    }
    @Override
    public void performService() {
        System.out.println("a survey was conducted");
    }
    @Override
    public int getServiceIntervalKm() {
        return 15000;
    }
}
