package sort.person;

import java.util.Comparator;
import java.util.Date;



public class SortPersonComparator implements Comparator {
	
	
	public String attribute;
	public boolean ascending; 
    public SortPersonComparator(String attribute, boolean ascending) {
        this.attribute = attribute;
        this.ascending = ascending;
    }
    
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		
		Person p1 = (Person)o1;
		Person p2 = (Person)o2;

		if (attribute.equals("firstName") || attribute.equals("lastName") || 
				attribute.equals("ssn")) {
			String value1 = "";
			String value2 = "";
			
			
			if (attribute.equals("firstName")) {
				value1 = p1.getFirstName();
				value2 = p2.getFirstName();
				
			}
            if (attribute.equals("lastName")) {
              	value1 = p1.getLastName();
				value2 = p2.getLastName();
			}
            
            if (attribute.equals("ssn")) {
              	value1 = p1.getSsn();
				value2 = p2.getSsn();
			}

			if (ascending) {
				return value1.toLowerCase().compareTo(value2.toLowerCase());
			} else {
				return value2.toLowerCase().compareTo(value1.toLowerCase());
			}
			
        }  else  if (attribute.equals("heightIn") || attribute.equals("weightLb") )  {
        	    double val1 = 0;
        	    double val2 = 0;
        	    if (attribute.equals("heightIn")) {
    				val1 = p1.getHeightIn();
    				val2 = p2.getHeightIn();
    				
    			} else {
    				val1 = p1.getWeightLb();
    				val2 = p2.getWeightLb();
    			}
             
        	    if (!ascending) {
        	    	  double temp = val2;
        	    	  val2 = val1;
        	    	  val1 = temp;
        	    }
            if (val1 > val2) {
                return 1;
            } else if (val1 < val2) {
                return -1;
            } else {
                return 0;
            }
        } else if (attribute.equals("dateOfBirth")) {
            Date d1 = p1.getDateOfBirth();
            Date d2 = p2.getDateOfBirth();
            if (ascending) {
            	  return d1.compareTo(d2);
            }
            return d2.compareTo(d1);
            
        }
		return 0;
	}
}
