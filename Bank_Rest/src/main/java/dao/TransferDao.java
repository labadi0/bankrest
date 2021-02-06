package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Transfer;

public interface TransferDao extends JpaRepository<Transfer, Integer> {

}
