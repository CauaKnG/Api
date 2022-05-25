package com.residencia.academia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.TurmaRepository;

@Service
public class TurmaService {
	@Autowired
	TurmaRepository turmaRepository;

	public List<Turma> findAllTurma() {
		return turmaRepository.findAll();
	}

	public Turma findTurmaById(Integer id) {
		return turmaRepository.findById(id).isPresent() ? turmaRepository.findById(id).get() : null;
	}

	public TurmaDTO findTurmaDTOById(Integer id) {
		Turma turma = turmaRepository.findById(id).isPresent() ? turmaRepository.findById(id).get() : null;

		TurmaDTO turmaDTO = new TurmaDTO();
		if (null != turma) {
			turmaDTO = converterEntidadeParaDto(turma);
		}

		return turmaDTO;
	}

	public Turma saveTurma(Turma turma) {
		return turmaRepository.save(turma);
	}

	public TurmaDTO saveTurmaDTO(TurmaDTO turmaDTO) {
		Turma turma = converterDtoParaEntidade(turmaDTO);
		Turma turmaNovo = turmaRepository.save(turma);
		return converterEntidadeParaDto(turmaNovo);
	}

	public Turma updateTurma(Turma turma) {
		return turmaRepository.save(turma);
	}

	public void deleteTurma(Integer id) {
		turmaRepository.deleteById(id);
	}

	private TurmaDTO converterEntidadeParaDto(Turma turma) {
		TurmaDTO turmaDTO = new TurmaDTO();
		if (null != turma) {
			turmaDTO.setDataFim(turma.getDataFim());
			turmaDTO.setDataInicio(turma.getDataInicio());
			turmaDTO.setIdTurma(turma.getIdTurma());
			turmaDTO.setDuracaoTurma(turma.getDuracaoTurma());
			turmaDTO.setHorarioTurma(turma.getHorarioTurma());
			turmaDTO.setAtividade(turma.getAtividade());
			turmaDTO.setInstrutor(turma.getInstrutor());

		}

		return turmaDTO;
	}

	private Turma converterDtoParaEntidade(TurmaDTO turmaDTO) {
		Turma turma = new Turma();
		if (null != turmaDTO) {
			turma.setDataFim(turmaDTO.getDataFim());
			turma.setDataInicio(turmaDTO.getDataInicio());
			turma.setIdTurma(turmaDTO.getIdTurma());
			turma.setDuracaoTurma(turmaDTO.getDuracaoTurma());
			turma.setHorarioTurma(turmaDTO.getHorarioTurma());
			turma.setAtividade(turmaDTO.getAtividade());
			turma.setInstrutor(turmaDTO.getInstrutor());
		}
		return turma;
	}
}
