package com.phonecompany.billing;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

public interface TelephoneBillCalculator {
    BigDecimal calculate (String phoneLog) ;
}
