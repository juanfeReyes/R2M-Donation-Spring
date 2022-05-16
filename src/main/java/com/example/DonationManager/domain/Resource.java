package com.example.DonationManager.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resource implements Serializable {

  private String id;

  private String description;

  private double amount;

  private String unit;
}
