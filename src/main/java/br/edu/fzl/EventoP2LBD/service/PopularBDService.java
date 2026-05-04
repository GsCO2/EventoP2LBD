package br.edu.fzl.EventoP2LBD.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import br.edu.fzl.EventoP2LBD.model.Curiosidade;
import br.edu.fzl.EventoP2LBD.model.Videogame;

@Service
public class PopularBDService {
	@Autowired
	private VideogameService vService;

	@Autowired
	private CuriosidadeService cService;

	public void verificaPopula() throws IOException {
		popularVideogames();
		popularCuriosidades();
	}

	private void popularVideogames() throws FileNotFoundException, IOException {
		if (vService.count() > 0) {	
			return;
		}

		File arquivo = ResourceUtils.getFile("classpath:txts/videogames.txt");
		if (arquivo.exists() && arquivo.isFile()) {
			FileInputStream flow = new FileInputStream(arquivo);
			InputStreamReader read = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(read);
			String linha;
			while ((linha = buffer.readLine()) != null) {
				Videogame v = new Videogame();
				v.setNome(linha.trim());
				vService.inserir(v);
			}
			buffer.close();
			read.close();
			flow.close();
		} else {
			throw new IOException("Arquivo Inválido");
		}
	}

	private void popularCuriosidades() throws IOException {
		List<Videogame> videogames = vService.listarTodos();
		for (Videogame v : videogames) {
			popularCuriosidades(v.getNome().toLowerCase() + ".txt", v);
		}
	}

	private void popularCuriosidades(String nomeArquivo, Videogame videogame) throws IOException {
		if (cService.countByVideogame(videogame) > 0) {
			return;
		}
		File arquivo = ResourceUtils.getFile("classpath:txts/" + nomeArquivo);
		if (arquivo.exists() && arquivo.isFile()) {
			FileInputStream flow = new FileInputStream(arquivo);
			InputStreamReader read = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(read);
			String linha;
			while ((linha = buffer.readLine()) != null) {
				Curiosidade c = new Curiosidade();
				c.setConteudo(linha.trim());
				c.setVideogame(videogame);	
				cService.inserir(c);
			}
			buffer.close();
			read.close();
			flow.close();
		} else {
			throw new IOException("Arquivo Inválido");
		}
	}
}
