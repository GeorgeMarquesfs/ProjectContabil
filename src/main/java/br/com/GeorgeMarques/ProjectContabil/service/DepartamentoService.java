package br.com.GeorgeMarques.ProjectContabil.service;

import br.com.GeorgeMarques.ProjectContabil.model.Departamento;
import br.com.GeorgeMarques.ProjectContabil.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<Departamento> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Departamento getDepartamentoById(Long id) {
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        return departamento.orElse(null);
    }

    public Departamento createDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public void deleteDepartamento(Long id) {
        departamentoRepository.deleteById(id);
    }
}
