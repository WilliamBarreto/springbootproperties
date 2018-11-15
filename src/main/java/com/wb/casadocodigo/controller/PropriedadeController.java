package com.wb.casadocodigo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wb.casadocodigo.domain.Propriedade;
import com.wb.casadocodigo.repository.PropriedadeRepository;

@RestController
@RequestMapping("/api")
public class PropriedadeController {

	@Autowired
	private PropriedadeRepository repository;

	@RequestMapping(value="/find/{filtro}", method = RequestMethod.GET)
	List<Propriedade> findByFiltro(@PathVariable("filtro") String filtro) {
		return repository.findByFiltro(filtro);
	}
	
	@RequestMapping(value="/find/", method = RequestMethod.GET)
	List<Propriedade> findAll() {
		return extractList(repository.findAll());
	}
	
	private List<Propriedade> extractList(Iterable<Propriedade> i) {
		List<Propriedade> list = new ArrayList<>();
		Iterator<Propriedade> iterator = i.iterator();
		while(iterator.hasNext()) { 
			Propriedade propriedade = iterator.next();
			list.add(propriedade); 
		}
		return list;
	}
}
