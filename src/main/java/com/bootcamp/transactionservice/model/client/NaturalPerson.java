package com.bootcamp.transactionservice.model.client;

import lombok.Data;

/**
 * NaturalPerson.
 */
@Data
public class NaturalPerson {

  private String idNaturalPerson;
  private String name;
  private String lastName;
  private String documentType;
  private String documentNumber;
  private String gender;
}
