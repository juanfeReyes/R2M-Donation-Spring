package com.example.DonationManager.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Donation implements Serializable {

  private String id;

  private String donor;

  private Date date;

  private String description;

  private String claimerId;

  private List<Resource> resources;
}
