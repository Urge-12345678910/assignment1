public class Bus extends Vehicle implements Servicable{
    private int passengerCapacity;

    public Bus(String model,int year,double basePrice,int passengerCapacity) {
        super(model,year,basePrice);
        this.passengerCapacity = passengerCapacity;
    }
    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    public void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity<= 0) {
            throw new IllegalArgumentException("pasenger capacity must be >0");
        }
        this.passengerCapacity = passengerCapacity;
    }
    @Override
    public double calculateInsuranceFee() {
        int age =getage(java.time.Year.now().getValue());
        return basePrice*0.06+passengerCapacity*50+age*70;
    }
    @Override
    public void performService() {
        System.out.println("a survey was conducted");
    }
    @Override
    public int getServiceIntervalKm() {
        return 10000;
    }
}
