package com.test_api.hello_workd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementRepositary repository;

    //CRUD  CREATE , READ , UPDATE , DELETE


    public Advertisement addAdvertisement(Advertisement Advertisement) {
        Advertisement.setAdvertisementId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(Advertisement);
    }

    public List<Advertisement> findAllAdvertisements() {
        return repository.findAll();
    }

    public Advertisement getAdvertisementByAdvertisementId(String AdvertisementId){
        return repository.findById(AdvertisementId).get();
    }


    public Advertisement updateAdvertisement(Advertisement AdvertisementRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        Advertisement existingAdvertisement = repository.findById(AdvertisementRequest.getAdvertisementId()).get();
        existingAdvertisement.setDescription(AdvertisementRequest.getDescription());
        existingAdvertisement.setImageUrl(AdvertisementRequest.getImageUrl());
        existingAdvertisement.setVisitLink(AdvertisementRequest.getVisitLink());
       
        return repository.save(existingAdvertisement);
    }

    public String deleteAdvertisement(String AdvertisementId){
        repository.deleteById(AdvertisementId);
        return AdvertisementId+" Advertisement deleted from dashboard ";
    }
} 
