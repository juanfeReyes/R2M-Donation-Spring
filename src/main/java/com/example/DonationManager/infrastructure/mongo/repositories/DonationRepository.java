package com.example.DonationManager.infrastructure.mongo.repositories;

import com.example.DonationManager.infrastructure.mongo.documents.DonationDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DonationRepository extends MongoRepository<DonationDocument, String> {
}
