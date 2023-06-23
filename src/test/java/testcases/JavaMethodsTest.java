package testcases;

import org.testng.annotations.Test;

public class JavaMethodsTest {

    @Test

    public void JavaMethodsTest() {

        int income = 89077;

        String a = "your tax will be 10%";
        String b = "your tax will be 12%";
        String c = "your tax will be 22%";
        String d = "please call your CPA";



        if (income>=0 && income<=10275){

            System.out.println(a);
        }

        else if (income>=10276 && income<=41775) {

            System.out.println(b);

        }
        else if (income>=41776 && income<=89075) {

            System.out.println(c);
        }
        else if (income>=89076) {

            System.out.println(d);
        }
    }

    @Test
    public void SwitchStatement(){

    String department = "gardening";

     switch (department) {
         case "sales":
             System.out.println("Sales depatrment works from 8am to 12pm.");
             break;
         case "clothing":
             System.out.println("Clothing depatrment works from 8am to 9pm.");
             break;
         case "cosmetics":
             System.out.println("Cosmetics depatrment works from 7am to 7pm.");
             break;
         case "furniture":
             System.out.println("Furniture depatrment works from 6am to 10pm.");
             break;
         case "gardening":
             System.out.println("Gardening depatrment works from 10am to 10pm.");
             break;
     }
    }

    @Test
    public void ForLoop(){

        for (int hour = 0; hour < 24; hour++) {
            System.out.println( + hour + " hour");
            hour++;

        }
    }
}
