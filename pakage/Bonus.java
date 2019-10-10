package pakage;

// this class is a new class as its extending BusinessLead class. moved the method from businessLead to Bonus class to make it more clear as whats the function 
//of these two methods. this class is with some new changes as needed.

public class Bonus extends BusinessLead{

	public Bonus(String name){
		
		super(name);

	}

	public boolean requestBonus(Employee e, double bonus){
        //Should check if the bonus amount requested would fit in current BusinessLead's budget.
        // If it is, that employee should get that bonus, the BusinessLeader's budget should be deducted and true should be returned. False should be returned otherwise
       if (bonus <= getBonusBudget()){
           this.bonusBudget -= bonus;
           e.bonusBudget += bonus;
           return true;
       } 
       else {
           return false;
       }
    }


    public boolean approveBonus(Employee e, double bonus){
        //This function should look through the Accountants the BusinessLead manages,
        // and if any of them are supporting a the TechnicalLead that is the manager of the Employee passed in then the Accountant's budget should be consulted to see if the bonus could be afforded.
        // If the team can afford the bonus it should be rewarded and true returned, false otherwise

        for (int i=0;i<directReport.size();i++){
			
            if((directReport.get(i).getTeamSupported()).equals(e.employeeManager)) {
		if(directReport.get(i).canApproveBonus(bonus)){
                e.bonus += bonus;
                directReport.get(i).bonusBudget -= bonus;
                return true;
            }
          }
		}
        return  false;
    }

	public String getTeamStatus() {
		// TODO Auto-generated method stub
		return "";
	}
    
}

