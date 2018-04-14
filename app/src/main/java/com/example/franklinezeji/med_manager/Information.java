package com.example.franklinezeji.med_manager;

/**
 * Created by Franklin Ezeji on 4/2/2018.
 */

public class Information {


    private String Name;
    private String Description;
    private String Interval;
    private String Start_Date;
    private String End_Date;

    public Information(String Name, String Description, String Interval, String Start_Date, String End_Date)

    {

        this.Name = Name;
        this.Description = Description;
        this.Interval = Interval;
        this.Start_Date = Start_Date;
        this.End_Date = End_Date;

    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public String getInterval() {
        return Interval;
    }

    public String getStart_Date() {
        return Start_Date;
    }

    public String getEnd_Date() {
        return End_Date;
    }
}
