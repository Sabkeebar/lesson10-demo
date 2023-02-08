package edu.miu.cs.cs425.fairfieldlibraryapp.service;

import edu.miu.cs.cs425.fairfieldlibraryapp.model.Publisher;

import java.util.List;

import org.springframework.data.domain.Page;

public interface PublisherService {

    public abstract List<Publisher> getPublishers();
    public abstract Page<Publisher> getPublishersPaged(int pageNo);
    Publisher addNewPublisher(Publisher newPublisher);
    Publisher updatePublisher(Integer publisherId, Publisher editedPublisher);
    Publisher getPublisherById(Integer publisherId);
    void deletePublisherById(Integer publisherId);

    Publisher findPublisherByName(String publisherName);
    List<Publisher> searchPublishers(String searchString);

}
