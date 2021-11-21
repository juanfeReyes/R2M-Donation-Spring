package com.example.DonationManager.infrastructure.searchEngine.document;

import com.example.DonationManager.domain.Donation;
import com.example.DonationManager.domain.DonationAudit;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;



@Document(indexName = "donation_audits")
@Builder
public class DonationAuditDocument {

  @Id
  private String id;

  private Donation donation;

  private String claimer;

  public static DonationAuditDocument toDocument(DonationAudit donationAudit){
    return DonationAuditDocument.builder()
        .donation(donationAudit.getDonation())
        .claimer(donationAudit.getClaimer())
        .build();
  }
}
