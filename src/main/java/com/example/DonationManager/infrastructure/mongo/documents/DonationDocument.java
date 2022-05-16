package com.example.DonationManager.infrastructure.mongo.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Document("Donation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonationDocument implements Serializable {

  @Id
  private String id;

  private String donor;

  private Date date;

  private String description;

  private String claimerId;

  private List<String> resourceIds;

}
