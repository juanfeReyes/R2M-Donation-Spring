package com.example.DonationManager.application.Donation;

import com.example.DonationManager.domain.DonationAudit;
import com.example.DonationManager.infrastructure.mongo.documents.DonationDocument;
import com.example.DonationManager.infrastructure.mongo.repositories.DonationRepository;
import com.example.DonationManager.infrastructure.searchEngine.document.DonationAuditDocument;
import com.example.DonationManager.infrastructure.searchEngine.document.DonationAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClaimDonation {

  private final DonationRepository donationRepository;

  private final DonationAuditRepository donationAuditRepository;

  @Autowired
  public ClaimDonation(DonationRepository donationRepository,
                       DonationAuditRepository donationAuditRepository){
    this.donationRepository = donationRepository;
    this.donationAuditRepository = donationAuditRepository;
  }

  public DonationAudit execute(String donationId, String claimer){

    var donation = donationRepository.findById(donationId).get();

    if(donation == null){
      throw new RuntimeException("Donation not found");
    }

    donationRepository.delete(donation);
    var donationAudit = new DonationAudit(DonationDocument.toEntity(donation), claimer);

    donationAuditRepository.save(DonationAuditDocument.toDocument(donationAudit));
    return donationAudit;
  }
}
