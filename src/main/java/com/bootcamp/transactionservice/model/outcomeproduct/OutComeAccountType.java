package com.bootcamp.transactionservice.model.outcomeproduct;

import lombok.Data;

@Data
public class OutComeAccountType {

  private String idOutComeAccountType;
  private String outcomeAccountDescription;
  private String maintenanceCharge;
  private Integer maximumProductsAllowed;
  private String maximumMonthlyTransactions;
}
