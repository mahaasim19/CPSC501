package pakage;
import java.util.ArrayList;

public abstract class BusinessLead extends BusinessEmployee implements TeamStatus{
	
    public ArrayList<Accountant> directReport;

    public BusinessLead(String name){
        //Should create a new BusinessLead that is a Manager.
        // The BusinessLead's base salary should be twice that of an Accountant.
        // They should start with a head count of 10.
        super(name);
        this.baseSalary=getBaseSalary()*2;
        this.headcount=10;
        this.directReport=new ArrayList<Accountant>();
    }

    public boolean hasHeadCount(){
        //Should return true if the number of direct reports this manager has is less than their headcount.
        if(this.directReport.size() < this.headcount){
            return true;
        } else {
            return false;
        }
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam){
        //Should accept the reference to an Accountant object, and if the BusinessLead has head count left should add this employee to their list of direct reports.
        // If the employee is successfully added to the BusinessLead's direct reports true should be returned, false should be returned otherwise.
        // Each time a report is added the BusinessLead's bonus budget should be increased by 1.1 times that new employee's base salary.
        // That employee's team they are supporting should be updated to reflect the reference to the TechnicalLead given.
        // If the employee is successfully added true should be returned, false otherwise.

        if (hasHeadCount()){

            directReport.add(e);
            e.setManager(this);
            this.bonusBudget += e.baseSalary * 1.1;
            e.supportTeam(supportTeam);
            supportTeam.accountantSupport=e;
            return true;
        } 
        else {
            return false;
        }
    }
    
    public abstract boolean requestBonus(Employee e, double bonus);
    public abstract boolean approveBonus(Employee e, double bonus);
    
}
