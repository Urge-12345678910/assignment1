public abstract class Vehicle {
    protected int id;
    protected static int idGen;
    protected String model;
    protected int year;
    protected double basePrice;
    protected Vehicle(String model,int year,double basePrice){
        this.id=idGen++;
        setmodel(model);
        setyear(year);
        setbasePrice(basePrice);
    }

    public int getId() {
        return id;
    }

    public String getmodel() {
        return model;
    }

    public int getyear() {
        return year;
    }

    public double getbaseprice() {
        return basePrice;
    }

    public void setmodel(String model) {
        if(model==null || model.trim().isEmpty()){
            throw new IllegalArgumentException("model cant be null or empty");
        }
        this.model = model;
    }

    public void setyear(int year) {
        int currentyear=java.time.Year.now().getValue();
        if( year<2000 || year>currentyear){
            throw new IllegalArgumentException("The year should be normal");
        }
        this.year = year;
    }

    public void setbasePrice(double basePrice) {
        if (basePrice<=0){
            throw new IllegalArgumentException("baseprice must be >0");
        }
        this.basePrice=basePrice;
    }
    public int getage(int currentyear){
        return currentyear-year;
    }
    public abstract double calculateInsuranceFee();
     @Override
    public String toString(){
         return "id: "+id+", model: "+model+", year: "+year+", baseprice: "+basePrice;
     }
}

