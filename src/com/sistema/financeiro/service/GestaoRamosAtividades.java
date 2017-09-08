package com.sistema.financeiro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sistema.financeiro.model.RamoAtividade;

public class GestaoRamosAtividades {
	
	private static Map<Integer, RamoAtividade> ramoAtividades = new HashMap<Integer, RamoAtividade>();
	
	static {
		ramoAtividades.put(1, new RamoAtividade(1, "Programador"));
		ramoAtividades.put(2, new RamoAtividade(2, "Engenheiro"));
		ramoAtividades.put(3, new RamoAtividade(3, "Arquiteto"));
		ramoAtividades.put(4, new RamoAtividade(4, "Mecanico"));
	}
	
	public List<RamoAtividade> buscarTodasAtividades(){
		List<RamoAtividade> atividade = new ArrayList<RamoAtividade>();
		atividade.addAll(GestaoRamosAtividades.ramoAtividades.values());
		return atividade;
	}
	
	public RamoAtividade buscarPorCodigoRamoAtividade(Integer codigo){
		return GestaoRamosAtividades.ramoAtividades.get(codigo);
	}

}
