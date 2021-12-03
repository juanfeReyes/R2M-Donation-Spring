package com.example.DonationManager.application.Donation;

import com.example.DonationManager.domain.Donation;
import com.example.DonationManager.infrastructure.mongo.documents.DonationDocument;
import com.example.DonationManager.infrastructure.mongo.repositories.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateDonation {

  private final DonationRepository donationRepository;

  @Autowired
  public CreateDonation(DonationRepository donationRepository) {
    this.donationRepository = donationRepository;
  }

  public void execute(Donation donation) {
    this.donationRepository.save(DonationDocument.toDocument(donation));
  }
}
