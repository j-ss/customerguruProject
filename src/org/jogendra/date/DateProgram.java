package org.jogendra.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateProgram {

  private static final SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
  private static Calendar calender= Calendar.getInstance();
  private static final Date currentDate;
  private static final int currentYear;
  private static final int currentMonth;
  private static final int currentDayDate;

  static{
    currentDate=new Date(System.currentTimeMillis());
    calender.setTime(currentDate);
    currentYear=calender.get(Calendar.YEAR);
    currentMonth=calender.get(Calendar.MONTH)+1;  //here we append 1 because month index start from 0 not 1
    currentDayDate=calender.get(Calendar.DATE);
  }

  public static void main(String[] args) throws ParseException {

    Scanner scanner=new Scanner(System.in);
    /**
     * Taking input from user
     */
    System.out.println("enter fromdate format(yyyy-mm-dd)");
    String fromdate = scanner.nextLine();
    System.out.println("enter todate format(yyyy-mm-dd)");
    String todate = scanner.nextLine();
    Date fromDate=format.parse(fromdate);
    Date toDate=format.parse(todate);
    /*
    check is date valid or not
     */
    boolean validateFromDate=isValid(fromDate,currentDate);
    boolean validateToDate=isValid(toDate,currentDate);
    boolean dateCompatible=isValid(fromDate,toDate);

    if(!dateCompatible){
      System.exit(0);
    }
    else{
      System.out.println("fromdate must be less or equal to to date");
    }
    if(validateFromDate){

      calender.setTime(fromDate);
      int year=calender.get(Calendar.YEAR);
      int month=calender.get(Calendar.MONTH)+1;
      int date=1;
      String newFromDate=year+"-"+month+"-"+date;
      fromDate=format.parse(newFromDate);

    }
    else {
      System.out.println("enter valid from date");
    }

    if(validateToDate){

      calender.setTime(toDate);
      int year=calender.get(Calendar.YEAR);
      int month=calender.get(Calendar.MONTH)+1;
      int date;

      if(year==currentYear&&month==currentMonth){
        date=currentDayDate;
      }
      else{
        date=calender.getActualMaximum(Calendar.DAY_OF_MONTH);
      }

      String newToDate=year+"-"+month+"-"+date;
      toDate=format.parse(newToDate);

    }
    else {
      System.out.println("enter valid to date");
    }

    //display new date
    System.out.println(format.format(fromDate));
    System.out.println(format.format(toDate));

    scanner.close();
  }

  public static boolean isValid(Date compareDate,Date currentDate){

    if(compareDate.compareTo(currentDate)<=0){
      return true;
    }
    else {
      return false;
    }
  }
}
