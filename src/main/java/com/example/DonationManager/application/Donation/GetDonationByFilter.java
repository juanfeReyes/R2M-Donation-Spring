package com.example.DonationManager.application.Donation;

import com.example.DonationManager.domain.Donation;
import com.example.DonationManager.domain.Resource;
import com.example.DonationManager.infrastructure.mongo.documents.DonationDocument;
import com.example.DonationManager.infrastructure.mongo.documents.DonationDocumentMapper;
import com.example.DonationManager.infrastructure.mongo.repositories.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class GetDonationByFilter {

  private final DonationRepository donationRepository;

  private final RedisTemplate<String, Object> redisTemplate;

  private final MongoTemplate mongoTemplate;

  private final DonationDocumentMapper donationDocumentMapper;

  @Autowired
  public GetDonationByFilter(DonationRepository donationRepository,
                             RedisTemplate<String, Object> redisTemplate, MongoTemplate mongoTemplate, DonationDocumentMapper donationDocumentMapper) {
    this.donationRepository = donationRepository;
    this.redisTemplate = redisTemplate;
    this.mongoTemplate = mongoTemplate;
    this.donationDocumentMapper = donationDocumentMapper;
  }

  public Donation execute(String id) {
    var donation = (Donation) redisTemplate.opsForValue().get(id);

    if (donation != null) {
      return donation;
    }

    donation = donationRepository.getDonationWithResources(id);
    redisTemplate.opsForValue().set(id, donation);
    return donation;
  }
}
