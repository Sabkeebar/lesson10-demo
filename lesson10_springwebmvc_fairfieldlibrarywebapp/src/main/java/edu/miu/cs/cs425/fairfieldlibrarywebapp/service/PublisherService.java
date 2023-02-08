package edu.miu.cs.cs425.fairfieldlibrarywebapp.service;

import edu.miu.cs.cs425.fairfieldlibrarywebapp.model.Publisher;
import org.springframework.data.domain.Page;

public interface PublisherService {

    public abstract Iterable<Publisher> getAllPublishers();
    public abstract Page<Publisher> getAllPublishersPaged(int pageNo);
    public abstract Publisher savePublisher(Publisher publisher);
    public abstract Publisher getPublisherById(Integer publisherId);
    public abstract Publisher updatePublisher(Publisher publisher);
    public abstract void deletePublisherById(Integer publisherId);
    public abstract void deletePrimaryAddressOfPublisher(Integer publisherId);

}
