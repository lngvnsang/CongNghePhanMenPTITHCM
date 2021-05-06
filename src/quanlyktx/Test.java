/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyktx;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author luong
 */
public class Test {

    public static void main(String[] args) {

        Calendar gc = new GregorianCalendar();
        gc.set(Calendar.MONTH, 0);
        gc.set(Calendar.DAY_OF_MONTH, 1);
        Date monthStart = gc.getTime();
        gc.add(Calendar.MONTH, 1);
        gc.add(Calendar.DAY_OF_MONTH, -1);
        Date monthEnd = gc.getTime();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy");
        SimpleDateFormat formatM = new SimpleDateFormat("MM");

        System.out.println("Calculated month start date : " + formatM.format(monthStart));
        System.out.println("Calculated month end date : " + formatM.format(monthEnd));
        
        int i= Integer.parseInt(formatM.format(monthEnd));
        System.out.println(i);
    }

}
