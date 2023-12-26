/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthcare;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class HealthReports implements Serializable {
    
    private List<String> reports;

    public HealthReports() {
        this.reports = new ArrayList<>();
    }

    public List<String> getReports() {
        return reports;
    }

    public void addReport(String entry) {
        reports.add(entry);
    }
    
}
