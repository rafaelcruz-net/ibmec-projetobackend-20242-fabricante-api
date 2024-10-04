package br.edu.ibmec.carfactory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ibmec.carfactory.model.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Integer> {
}
