package edu.miu.cs.cs425.fairfieldlibraryapp.service.impl;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Publisher;
import edu.miu.cs.cs425.fairfieldlibraryapp.repository.PublisherRepository;
import edu.miu.cs.cs425.fairfieldlibraryapp.service.PublisherService;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    private PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> getPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher addNewPublisher(Publisher newPublisher) {
        return publisherRepository.save(newPublisher);
    }

    @Override
    public Publisher updatePublisher(Integer publisherId, Publisher editedPublisher) {
        var thePublisher = publisherRepository.findById(publisherId).orElse(null);
        if(thePublisher != null) {
            thePublisher.setName(editedPublisher.getName());
            publisherRepository.save(thePublisher);
        }
        return thePublisher;
    }

    @Override
    public Publisher getPublisherById(Integer publisherId) {
        return publisherRepository.findById(publisherId).orElse(null);
    }

    @Override
    public void deletePublisherById(Integer publisherId) {
        publisherRepository.deleteById(publisherId);
    }

    @Override
    public Publisher findPublisherByName(String publisherName) {
        return publisherRepository.findOnePublisherByName(publisherName)
                .orElse(null);
    }

    @Override
    public Page<Publisher> getPublishersPaged(int pageNo) {
        return publisherRepository.findAll(PageRequest.of(pageNo, 3, Direction.ASC, "name"));
    }

    @Override
    public List<Publisher> searchPublishers(String searchString) {
        return publisherRepository.findAllByNameContainingOrPrimaryAddress_StreetContainingOrPrimaryAddress_CityContainingOrPrimaryAddress_StateContainingOrPrimaryAddress_ZipCodeContaining(
            searchString, searchString, searchString, searchString, searchString);
    }

}
