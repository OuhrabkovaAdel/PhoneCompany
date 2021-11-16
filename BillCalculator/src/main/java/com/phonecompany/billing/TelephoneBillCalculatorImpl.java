package com.phonecompany.billing;


import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class TelephoneBillCalculatorImpl implements TelephoneBillCalculator {

    public BigDecimal calculate(String phoneLog) {
        String line = "";
        String splitBy = ",";
        String[] oneLine;
        BigDecimal sum = new BigDecimal(0.0);

            try {
                BufferedReader br = new BufferedReader(new FileReader(phoneLog));
                while ((line = br.readLine()) != null) {
                    oneLine = line.split(splitBy);
                    System.out.println("Phone: " + oneLine[0] + ", from:" + oneLine[1] + ", to:" + oneLine[2]);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    LocalDateTime dateTimeFrom = LocalDateTime.parse(oneLine[1], formatter);
                    LocalDateTime dateTimeTo = LocalDateTime.parse(oneLine[2], formatter);

                    long diff = dateTimeTo.getSecond() - dateTimeFrom.getSecond();
                    long hour = dateTimeFrom.getHour();

                    System.out.println(hour);
                    System.out.println(diff);

                    if(hour > 16 && hour < 8) {
                        if (diff > 5) {
                            sum.add(BigDecimal.valueOf(2.5 + ((diff - 5) * 0.2)));
                        } else {
                            sum.add(BigDecimal.valueOf(diff * 0.5));
                        }
                    } else {
                        if (diff > 5) {
                            sum.add(BigDecimal.valueOf(5 + ((diff - 5) * 0.2)));
                        } else {
                            sum.add(BigDecimal.valueOf(diff));
                        }
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sum;
    }
}
