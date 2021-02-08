package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import entity.Transfer;

//@RepositoryRestResource
public interface TransferDao extends JpaRepository<Transfer, Integer> {

}
