package br.edu.fzl.EventoP2LBD.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.fzl.EventoP2LBD.model.Mensagem;
import br.edu.fzl.EventoP2LBD.service.MensagemService;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminTipoController {

	@Autowired
	private MensagemService mService;

	@RequestMapping(name = "cadastraTipo", value = "/cadastraTipo", method = RequestMethod.GET)
	public ModelAndView mensagemGet(@RequestParam Map<String, String> params, 
			ModelMap model, HttpSession session) {
		if (!isAdmin(session)) {
			return new ModelAndView("redirect:/login");
		}

		String acao = params.get("acao");
		String id = params.get("id");

		Mensagem m = new Mensagem();
		List<Mensagem> mensagens = new ArrayList<>();
		String erro = "";

		try {
			if (id != null && !id.isEmpty()) {
				int codigo = Integer.parseInt(id);
				m.setId(codigo);

				if ("excluir".equalsIgnoreCase(acao)) {
					mService.excluir(m);
					mensagens = mService.listar();
					m = null;

				} else if ("editar".equalsIgnoreCase(acao)) {
					m = mService.buscar(m);

				} else {
					m = null;
				}
			}
		} catch (Exception e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("mensagem", m);
			model.addAttribute("mensagens", mensagens);
			model.addAttribute("erro", erro);
		}

		return new ModelAndView("cadastraTipo");
	}

	@RequestMapping(name = "cadastraTipo", value = "/cadastraTipo", method = RequestMethod.POST)
	public ModelAndView mensagemPost(@RequestParam Map<String, String> params, 
			ModelMap model, HttpSession session) {

		if (!isAdmin(session)) {
		    return new ModelAndView("redirect:/login");
		}

		String id = params.get("id");
		String conteudo = params.get("conteudo");
		String tipo = params.get("tipo");
		String cmd = params.get("acao");

		Mensagem m = new Mensagem();
		List<Mensagem> mensagens = new ArrayList<>();
		String erro = "";
		String saida = "";

		try {
			if (!cmd.equalsIgnoreCase("Listar") && !cmd.equalsIgnoreCase("Inserir")) {
				int codigo = Integer.parseInt(id);
				m.setId(codigo);
			}

			if (cmd.equalsIgnoreCase("Inserir") || cmd.equalsIgnoreCase("Atualizar")) {
				m.setConteudo(conteudo);
				m.setTipo(tipo);
			}

			if (cmd.equalsIgnoreCase("Inserir")) {
				saida = mService.inserir(m);
			}

			if (cmd.equalsIgnoreCase("Atualizar")) {
				saida = mService.alterar(m);
			}

			if (cmd.equalsIgnoreCase("Excluir")) {
				saida = mService.excluir(m);
			}

			if (cmd.equalsIgnoreCase("Buscar")) {
				m = mService.buscar(m);
			}

			if (cmd.equalsIgnoreCase("Listar")) {
				mensagens = mService.listar();
			}

		} catch (Exception e) {
			erro = e.getMessage();
		} finally {

			if (!cmd.equalsIgnoreCase("Buscar")) {
				m = null;
			}

			if (!cmd.equalsIgnoreCase("Listar")) {
				mensagens = null;
			}

			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("mensagem", m);
			model.addAttribute("mensagens", mensagens);
		}

		return new ModelAndView("cadastraTipo");
	}

	private boolean isAdmin(HttpSession session) {
		Boolean logado = (Boolean) session.getAttribute("adminLogado");
		return logado != null && logado;
	}
}