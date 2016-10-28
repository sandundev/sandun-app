package com.meganexus.commit.client.profile.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.meganexus.commit.client.profile.model.core.ClientProfile;

@RepositoryRestResource(collectionResourceRel = "profile-repository", path = "profile-repository")
public interface ClientProfileRepository extends PagingAndSortingRepository<ClientProfile, Long> {

}
