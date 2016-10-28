package com.sandun.personal.project.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sandun.personal.project.model.core.SandunLewke;

@RepositoryRestResource(collectionResourceRel = "sandun-lewke-repository", path = "sandun-lewke-repository")
public interface SandunLewkeRepository extends PagingAndSortingRepository<SandunLewke, Long> {

}
