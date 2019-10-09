public class TechnicalEmployee extends Employee {
    public int successfulCheckins;


    public TechnicalEmployee(String name){
        //Has a default base salary of 75000
        super(name,75000.00);
        successfulCheckins=0;
    }

    public String employeeStatus(){
        //Should return a String representation of this TechnicalEmployee that includes their ID, name and how many successful check ins they have had.
        // Example: "1 Kasey has 10 successful check ins"
        return super.toString()+" has "+successfulCheckins+" successful check ins";
    }

    public void setCheckin(){
        successfulCheckins++;
    }


}
