package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.HRAplipage;
import pages.MyApplicationPage;
import utilities.Configuration;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.JDBCUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HRApplicationSteps {
    HRAplipage hrAplipage =new HRAplipage();
    Map<String,Object> uiData=new HashMap<String,Object>();

    List<Map<String,Object>> listOfMaps=new ArrayList<>();

    @Given("^Navigate  to the DataBase$")
    public void navigate_to_the_DataBase() throws Throwable {
        Driver.driver.get(Configuration.getProperties("hrProgectUrl"));
   // JDBCUtils.establishConnection();
    }

    @When("^Get first_name and last_name  of employees who works in Europe validate with their UI information \\(First name, Last Name\\)$")
    public void get_first_name_and_last_name_of_employees_who_works_in_Europe_validate_with_their_UI_information_First_name_Last_Name() throws Throwable {
    listOfMaps=JDBCUtils.runSQLQuery("select  first_name, last_name"+
        "from employees e join departments d on"+
        "e.department_id=d.department_id"+
        "join locations l on"+
       " d.location_id=l.location_id"+
        "join countries c on"+
        "l.country_id=c.country_id"+
        "join regions r on"+
        "c.region_id=r.region_id"+
        "where r.region_name='Europe'");
        JDBCUtils.establishConnection();
        //System.out.println(dbData=JDBCUtils.runSQLQuery(query));
        System.out.println("List of Maps size:  " +listOfMaps.size());
//        for(Map<String,Object>fullName:dbData){
//
//        }
//        System.out.println();
//        System.out.println(JDBCUtils.countRows(query));
//        int actual=JDBCUtils.countRows(query);
//
//        int indexOfRow =0;
       // for (WebElement elements )


    }

    @Then("^go to Excel \"([^\"]*)\" \"([^\"]*)\" and update column 'Actual # of Employees' with number of Europe employees that you get from UI\\.$")
    public void go_to_Excel_and_update_column_Actual_of_Employees_with_number_of_Europe_employees_that_you_get_from_UI(String arg1, String arg2) throws Throwable {
int size=listOfMaps.size();
        System.out.println(size);
        String sizes=""+size;
        ExcelUtils.openExcelFile("testData","Sheet3");
        ExcelUtils.setValue(sizes,1,2);
    }

    @Then("^Compare ‘Actual # of Employees’’ with ‘expected # of Employees’$")
    public void compare_Actual_of_Employees_with_expected_of_Employees() throws Throwable {
        ExcelUtils.openExcelFile("testData","Sheet3");
        double Expected=Double.parseDouble(ExcelUtils.getValue(1,1));
        double actual=Double.parseDouble(ExcelUtils.getValue(1,2));

    }

    @Then("^if they matched then update ‘Test Execution Status’ cell as \"([^\"]*)\" if not match then update with \"([^\"]*)\"\\.$")
    public void if_they_matched_then_update_Test_Execution_Status_cell_as_if_not_match_then_update_with(String arg1, String arg2) throws Throwable {
        ExcelUtils.openExcelFile("testData","Sheet3");
        double Expected=Double.parseDouble(ExcelUtils.getValue(1,1));
        double actual=Double.parseDouble(ExcelUtils.getValue(1,2));
        System.out.println(Expected);
        System.out.println(actual);

        if (Expected==actual) {
            ExcelUtils.setValue("PASSED", 1, 3);
        }else{ExcelUtils.setValue("FAILED",1,3);
            Assert.assertEquals(Expected,actual,1);

    }





}}
