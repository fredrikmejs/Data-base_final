package Tecnical_Services;

import java.util.Date;

public interface IRecipeDTO {

     int getId();
     void setId(int id);

     Date getDate();
     void setDate(Date date);


     String getName();
     void getName(String name);

     boolean getIsInUse();
     void setIsInUse(boolean inUse);

}
